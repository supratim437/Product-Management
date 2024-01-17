package com.project.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Service;

import com.project.demo.dto.ProductDTO;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public void saveOrupdate(ProductDTO productDTO) {
		if (productDTO.getProductId() == null) {
			String query = "insert into tbl_product(product_title,company_name,price) values(?,?,?)";
			jdbc.update(query, productDTO.getTitle(), productDTO.getCompanyName(), productDTO.getPrice());
		} else {
			String query = "UPDATE tbl_product set product_title=? , company_name=?,price=? where product_id=?";
			jdbc.update(query, productDTO.getTitle(), productDTO.getCompanyName(), productDTO.getPrice(),productDTO.getProductId());

		}

	}

	@Override
	public void delete(int id) {
		String query = "Delete from tbl_product where product_Id=?";
		jdbc.update(query, id);

	}

	@Override
	public List<ProductDTO> getProducts() {
		List<ProductDTO> list = jdbc.query("select * from tbl_product", new RowMapper<ProductDTO>() {

			@Override
			public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductDTO product = new ProductDTO();
				product.setProductId(rs.getInt("product_Id"));
				product.setTitle(rs.getString("product_title"));
				product.setCompanyName(rs.getString("company_Name"));
				product.setPrice(rs.getDouble("price"));

				return product;
			}
		});
		return list;
	}

	@Override
	public ProductDTO get(int id) {
		
		String query = "select * from tbl_product where product_id=?";
		ProductDTO product= jdbc.queryForObject(query, new Object[] {id}, new RowMapper<ProductDTO>() {

			@Override
			public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductDTO product = new ProductDTO();
				product.setProductId(rs.getInt("product_Id"));
				product.setTitle(rs.getString("product_title"));
				product.setCompanyName(rs.getString("company_Name"));
				product.setPrice(rs.getDouble("price"));

				return product;
			}
				
		});
		return product;
		
	}

}
