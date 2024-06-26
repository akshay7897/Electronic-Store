package com.ap.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ap.dtos.CategoryRequest;
import com.ap.dtos.CategoryResponse;
import com.ap.dtos.PageableResponse;
import com.ap.entity.Category;
import com.ap.exception.CategoryNotFounException;
import com.ap.repository.CategoryRepository;
import com.ap.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public CategoryResponse createCategory(CategoryRequest request) {
		Category category = convertToEntity(request);
		Category savedCategory = null;
		try {
		 savedCategory = categoryRepository.save(category);
		}catch (Exception e) {
			throw new RuntimeException("Exception ouccred while saving category details");
		}
		return convertToResponse(savedCategory);
	}

	@Override
	public CategoryResponse updateCategory(CategoryRequest request, String categoryId) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(()->new CategoryNotFounException("Category not available with given id"));
		
		if(null!=request.getTitle() && !"".equals(request.getTitle()))
			category.setTitle(request.getTitle());
		if(null!=request.getDescription() && !"".equals(request.getDescription()))
			category.setDescription(request.getDescription());
		if(null!=request.getCoverImage() && !"".equals(request.getCoverImage()))
			category.setCoverImage(request.getCoverImage());
		
		Category updatedCategory = categoryRepository.save(category);
		return convertToResponse(updatedCategory);
	}


	@Override
	public boolean deleteCategory(String categoryId) {
		boolean existsById = categoryRepository.existsById(categoryId);
		if(existsById) {
			categoryRepository.deleteById(categoryId);
			return true;
		}else {
			throw new CategoryNotFounException("With given Id Category not found...!");
		}
	}

	@Override
	public PageableResponse<CategoryResponse>  getAllCategories(int pageNumber,int pageSize,String sortBy,String sortdir) {
		
		
		Sort sort = (sortdir.equalsIgnoreCase("asc")) ? (Sort.by(sortBy).ascending()) : (Sort.by(sortBy).descending());
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		 Page<Category> page = categoryRepository.findAll(pageable);
		 List<Category> categoryList = page.getContent();
		
		List<CategoryResponse> list = categoryList.stream().map(category->convertToResponse(category)).toList();
		PageableResponse<CategoryResponse> response=new PageableResponse<>();
		response.setContent(list);
		response.setLastpage(page.isLast());
		response.setPageNumber(page.getNumber());
		response.setPageSize(page.getSize());
		response.setTotalElements(page.getTotalElements());
		response.setTotalPages(page.getTotalPages());
		
		return response;
		 
	}

	@Override
	public CategoryResponse getCategoryById(String categoryId) {
		return convertToResponse(categoryRepository.findById(categoryId)
				.orElseThrow(() -> new CategoryNotFounException("Category not available with given id")));
	}
	
	private Category convertToEntity(CategoryRequest request) {
		Category category=new Category();
		BeanUtils.copyProperties(request, category);
		return category;
	}
	
	private CategoryResponse convertToResponse(Category category) {
		CategoryResponse response=new CategoryResponse();
		BeanUtils.copyProperties(category, response);
		return response;

	}
	

}
