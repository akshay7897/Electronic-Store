package com.ap.service;

import com.ap.dtos.PageableResponse;
import com.ap.dtos.ProductRequest;
import com.ap.dtos.ProductResponse;

public interface ProductService {
	
	
	ProductResponse createProduct(ProductRequest request);
	
	ProductResponse updateProduct(ProductRequest request,String productId);
	
	ProductResponse getProduct(String productId);
	
	boolean deleteProduct(String productId);
	
	PageableResponse<ProductResponse> getAllProducts(int pageNumber,int pageSize,String sortBy,String sortdir);
	
	PageableResponse<ProductResponse> getLiveProduct(int pageNumber, int pageSize, String sortBy,
			String sortdir);
	
	PageableResponse<ProductResponse> serachByTitle(int pageNumber, int pageSize, String sortBy,
			String sortdir,String subTitle);
	
	
	ProductResponse createProductWithCategory(ProductRequest request,String categoryId);
	
	
	ProductResponse updateProductwithCategoryId(String categoryId,String productId);
	
	
	
	PageableResponse<ProductResponse> getProductByCategory(int pageNumber, int pageSize,
			String sortBy, String sortdir,String categoryId);
	

}
