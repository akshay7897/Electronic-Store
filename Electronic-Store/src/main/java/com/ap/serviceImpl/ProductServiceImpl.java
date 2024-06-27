package com.ap.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ap.dtos.PageableResponse;
import com.ap.dtos.ProductRequest;
import com.ap.dtos.ProductResponse;
import com.ap.entity.Product;
import com.ap.exception.ProductNotFountException;
import com.ap.repository.ProductRepository;
import com.ap.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public ProductResponse createProduct(ProductRequest request) {
		String id = UUID.randomUUID().toString();
		request.setProductId(id);
		Product savedProduct = null;
		try {
			savedProduct = productRepository.save(toEntity(request));

		} catch (Exception ex) {
			throw new RuntimeException("Exception occured while saving product details...!");
		}
		return toResponse(savedProduct);
	}

	@Override
	public ProductResponse updateProduct(ProductRequest request, String productId) {

		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFountException("Product not found with given id...!"));

		product.setDescreption(request.getDescreption());
		product.setDiscountedPrice(request.getDiscountedPrice());
		product.setPrice(request.getPrice());
		product.setQuantity(request.getQuantity());
		product.setTitle(request.getTitle());
		product.setLive(request.isLive());
		product.setStock(request.isStock());

		Product updateProduct = null;
		try {
			updateProduct = productRepository.save(product);
		} catch (Exception ex) {
			throw new RuntimeException("Exception occured while updating product details...!");
		}
		return toResponse(updateProduct);
	}

	@Override
	public ProductResponse getProduct(String productId) {
		return toResponse(productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFountException("Product not found with given id...!")));
	}

	@Override
	public PageableResponse<ProductResponse> getAllProducts(int pageNumber, int pageSize, String sortBy,
			String sortdir) {

		Sort sort = (sortdir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Page<Product> page = productRepository.findAll(pageable);
		List<Product> products = page.getContent();

		PageableResponse<ProductResponse> pageableResponse = new PageableResponse<>();
		pageableResponse.setContent(products.stream().map(product -> toResponse(product)).toList());
		pageableResponse.setLastpage(page.isLast());
		pageableResponse.setPageNumber(page.getNumber());
		pageableResponse.setPageSize(page.getSize());
		pageableResponse.setTotalElements(page.getTotalElements());
		pageableResponse.setTotalPages(page.getTotalPages());

		return pageableResponse;
	}

	@Override
	public PageableResponse<ProductResponse> serachByTitle(int pageNumber, int pageSize, String sortBy, String sortdir,
			String subTitle) {
		Sort sort = (sortdir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Page<Product> page = productRepository.findByTitleContaining(subTitle, pageable);
		List<Product> products = page.getContent();

		PageableResponse<ProductResponse> pageableResponse = new PageableResponse<>();
		pageableResponse.setContent(products.stream().map(product -> toResponse(product)).toList());
		pageableResponse.setLastpage(page.isLast());
		pageableResponse.setPageNumber(page.getNumber());
		pageableResponse.setPageSize(page.getSize());
		pageableResponse.setTotalElements(page.getTotalElements());
		pageableResponse.setTotalPages(page.getTotalPages());

		return pageableResponse;
	}

	@Override
	public boolean deleteProduct(String productId) {
		boolean existsById = productRepository.existsById(productId);
		if (existsById) {
			productRepository.deleteById(productId);
			return true;
		} else {
			throw new ProductNotFountException("Product not found with given id...!");
		}
	}

	@Override
	public PageableResponse<ProductResponse> getLiveProduct( int pageNumber, int pageSize,
			String sortBy, String sortdir) {
		Sort sort = (sortdir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Page<Product> page = productRepository.findByLive(Boolean.TRUE, pageable);
		List<Product> products = page.getContent();

		PageableResponse<ProductResponse> pageableResponse = new PageableResponse<>();
		pageableResponse.setContent(products.stream().map(product -> toResponse(product)).toList());
		pageableResponse.setLastpage(page.isLast());
		pageableResponse.setPageNumber(page.getNumber());
		pageableResponse.setPageSize(page.getSize());
		pageableResponse.setTotalElements(page.getTotalElements());
		pageableResponse.setTotalPages(page.getTotalPages());

		return pageableResponse;
	}

	private Product toEntity(ProductRequest request) {
		Product product = new Product();
		BeanUtils.copyProperties(request, product);
		return product;
	}

	private ProductResponse toResponse(Product product) {
		ProductResponse response = new ProductResponse();
		BeanUtils.copyProperties(product, response);
		return response;
	}

}