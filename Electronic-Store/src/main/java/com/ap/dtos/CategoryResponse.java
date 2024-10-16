package com.ap.dtos;

public class CategoryResponse {

	private String categoryId;
	private String title;
	private String description;
	private String coverImage;

	public CategoryResponse() {
		//
	}

	public CategoryResponse(String categoryId, String title, String description, String coverImage) {
		super();
		this.categoryId = categoryId;
		this.title = title;
		this.description = description;
		this.coverImage = coverImage;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	@Override
	public String toString() {
		return "CategoryResponse [categoryId=" + categoryId + ", title=" + title + ", description=" + description
				+ ", coverImage=" + coverImage + "]";
	}

}
