package com.ap.dtos;

import java.util.List;

public class PageableResponse<T> {
	
	private List<T> content;
	private int pageSize;
	private int pageNumber;
	private long  totalElements;
	private int totalPages;
	private boolean lastpage;
	
	public PageableResponse() {
		// 
	}

	public PageableResponse(List<T> content, int pageSize, int pageNumber, long totalElements, int totalPages,
			boolean lastpage) {
		this.content = content;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.lastpage = lastpage;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isLastpage() {
		return lastpage;
	}

	public void setLastpage(boolean lastpage) {
		this.lastpage = lastpage;
	}

	@Override
	public String toString() {
		return "PageableResponse [content=" + content + ", pageSize=" + pageSize + ", pageNumber=" + pageNumber
				+ ", totalElements=" + totalElements + ", totalPages=" + totalPages + ", lastpage=" + lastpage + "]";
	}
	
	
	
	

}
