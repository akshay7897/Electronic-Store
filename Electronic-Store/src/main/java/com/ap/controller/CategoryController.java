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
import com.ap.dtos.ProductRequest;
import com.ap.dtos.ProductResponse;
import com.ap.service.CategoryService;
import com.ap.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	private CategoryService categoryService;
	
	private ProductService productService;
	
	public CategoryController(CategoryService categoryService, ProductService productService) {
		super();
		this.categoryService = categoryService;
		this.productService = productService;
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
			@RequestParam(value = "sortBy", defaultValue = "title", required = false) String sortBy,
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
	
	
	//create product with categoryId
	@PostMapping("/{categoryId}/product")
	public ResponseEntity<ProductResponse> createProductWithCategory(@Valid @RequestBody ProductRequest request,
			@PathVariable String categoryId) {
		
		ProductResponse productResponse = productService.createProductWithCategory(request, categoryId);
		
		return new ResponseEntity<>(productResponse, HttpStatus.CREATED);

	}
	
	
	@PutMapping("/{categoryId}/product/{productId}")
	public ResponseEntity<ProductResponse> updateProductWithCategoryId(
			@PathVariable String categoryId,@PathVariable String productId) {
		
		ProductResponse productResponse = productService.updateProductwithCategoryId(categoryId, productId);
		
		return new ResponseEntity<>(productResponse, HttpStatus.OK);

	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<PageableResponse<ProductResponse>> getProductsByCategoryId(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "title", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortdir,
			@PathVariable String categoryId
			){
		
		PageableResponse<ProductResponse> pageableResponse = productService.getProductByCategory(pageNumber, pageSize, sortBy, sortdir, categoryId);
		
		return new ResponseEntity<>(pageableResponse,HttpStatus.OK);
	}
	

}
