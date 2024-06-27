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
import com.ap.dtos.PageableResponse;
import com.ap.dtos.ProductRequest;
import com.ap.dtos.ProductResponse;
import com.ap.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request){
		ProductResponse savedProduct = productService.createProduct(request);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
		
	}

	@PutMapping("/update/{productId}")
	public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request,@PathVariable String productId){
		ProductResponse updatedProduct = productService.updateProduct(request, productId);
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<ApiResponseMessage> deleteProduct(@PathVariable String productId){
		
		boolean deleteProduct = productService.deleteProduct(productId);
		if(deleteProduct) {
			return new ResponseEntity<>(new ApiResponseMessage("Product Deleted Successfully..!", Boolean.TRUE,HttpStatus.OK),HttpStatus.OK);
		}else {
			throw new RuntimeException("Product not deleted..!");
		}
	}
	
	@GetMapping("/get/{productId}")
	public ResponseEntity<ProductResponse> getProduct(@PathVariable String productId){
		ProductResponse productResponse = productService.getProduct(productId);
		return new ResponseEntity<ProductResponse>(productResponse,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<PageableResponse<ProductResponse>> getAllProducts(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "title", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortdir
			){
		PageableResponse<ProductResponse> allProducts = productService.getAllProducts(pageNumber, pageSize, sortBy, sortdir);
		return new ResponseEntity<>(allProducts,HttpStatus.OK);
	}
	
	
	@GetMapping("/liveProducts")
	public ResponseEntity<PageableResponse<ProductResponse>> getAllLiveProducts(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "title", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortdir
			){
		
		 PageableResponse<ProductResponse> liveProduct = productService.getLiveProduct(pageNumber, pageSize, sortBy, sortdir);
		return new ResponseEntity<>(liveProduct,HttpStatus.OK);
	}
	
	@GetMapping("/searchProducts")
	public ResponseEntity<PageableResponse<ProductResponse>> searchProducts(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "title", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortdir,
			@RequestParam(value = "subTitle") String subTitle
			){
		
		PageableResponse<ProductResponse> searchedProducts = productService.serachByTitle(pageNumber, pageSize, sortBy, sortdir, subTitle);
		
		return new ResponseEntity<>(searchedProducts,HttpStatus.OK);
	}
	

}
