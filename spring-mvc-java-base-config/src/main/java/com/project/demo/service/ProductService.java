package com.project.demo.service;

import java.util.List;

import com.project.demo.dto.ProductDTO;

public interface ProductService {

	public void saveOrupdate(ProductDTO productDTO);
	public void delete(int id);
	public ProductDTO get(int id);
	public List<ProductDTO> getProducts();
	

}
