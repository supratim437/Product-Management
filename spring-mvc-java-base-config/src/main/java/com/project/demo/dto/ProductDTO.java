package com.project.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDTO {
	
	private Integer productId;
	@NotBlank(message="product name should not be blank")
	private String title;
	@NotBlank(message="company name should not be blank")
	private String companyName;
	@NotNull(message="price should not be blank")
	private Double price;

	public ProductDTO() {

	}

	public ProductDTO(Integer productId, String title, String companyName, Double price) {
		super();
		this.productId = productId;
		this.title = title;
		this.companyName = companyName;
		this.price = price;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ProductDTO(String title, String companyName, Double price) {
		super();
		this.title = title;
		this.companyName = companyName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", title=" + title + ", companyName=" + companyName + ", price="
				+ price + "]";
	}

}
	

