package com.ap.service;

import com.ap.dtos.CategoryRequest;
import com.ap.dtos.CategoryResponse;
import com.ap.dtos.PageableResponse;

public interface CategoryService {
	
	
	CategoryResponse createCategory(CategoryRequest request);
	
	CategoryResponse updateCategory(CategoryRequest request,String categoryId);
	
	boolean deleteCategory(String categoryId);
	
	PageableResponse<CategoryResponse> getAllCategories(int pageNumber,int pageSize,String sortBy,String sortdir);
	
	CategoryResponse getCategoryById(String categoryId);

}
