package com.ap.dtos;

import jakarta.validation.constraints.NotBlank;

public class CategoryRequest {

	private String categoryId;
	@NotBlank(message = "Title should not be null")
	private String title;
	@NotBlank(message = "Description should not be null")
	private String description;
	@NotBlank(message = "coverImage should not be null")
	private String coverImage;

	public CategoryRequest() {
		//
	}

	public CategoryRequest(String categoryId, String title, String description, String coverImage) {
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
		return "CategoryRequest [categoryId=" + categoryId + ", title=" + title + ", description=" + description
				+ ", coverImage=" + coverImage + "]";
	}

}
