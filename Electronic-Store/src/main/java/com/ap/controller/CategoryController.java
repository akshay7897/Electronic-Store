package com.ap.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ap.dtos.ApiResponseMessage;
import com.ap.dtos.CategoryRequest;
import com.ap.dtos.CategoryResponse;
import com.ap.dtos.PageableResponse;
import com.ap.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	private CategoryService categoryService;
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request){
		
		CategoryResponse categoryResponse = categoryService.createCategory(request);
		return new ResponseEntity<>(categoryResponse,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{categodryId}")
	public ResponseEntity<CategoryResponse> updateCategory(@Valid @RequestBody CategoryRequest request,@PathVariable String categodryId){
		
		CategoryResponse updateCategory = categoryService.updateCategory(request, categodryId);
		return new ResponseEntity<>(updateCategory,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{catogoryId}")
	public ResponseEntity<ApiResponseMessage> deleteCategory(@PathVariable String catogoryId){
		
		boolean deleteCategory = categoryService.deleteCategory(catogoryId);
		if(deleteCategory) {
			return new ResponseEntity<>(new ApiResponseMessage("Category Deleted", true,HttpStatus.OK),HttpStatus.OK);
		}else {
			throw new RuntimeException("Category not delted");
		}
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<PageableResponse<CategoryResponse>> getAllCategories(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "name", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortdir) {

		PageableResponse<CategoryResponse> response = categoryService.getAllCategories(pageNumber, pageSize, sortBy,
				sortdir);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("get/{categoryId}")
	public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable String categoryId){
		
		CategoryResponse categoryById = categoryService.getCategoryById(categoryId);
		return new ResponseEntity<>(categoryById, HttpStatus.OK);
		
	}
	

}
