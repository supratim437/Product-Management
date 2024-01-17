package com.project.demo.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.protobuf.Value;
import com.project.demo.dto.ProductDTO;
import com.project.demo.service.ProductService;
import com.project.demo.service.ProductServiceImpl;

@Controller
public class TestController {
	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public String welcomePageCall() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String p = bCryptPasswordEncoder.encode("SomeCoolPassword");
		System.out.println(p);
		System.out.println(bCryptPasswordEncoder.matches("SomeCoolPasswor", p));
		return "welcome";

	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String productPage(@ModelAttribute("productDTO") ProductDTO productDTO) {

		return "product";
	}

	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("productDTO") ProductDTO productDTO,BindingResult result) {
		if(result.hasErrors()) {
			return "product";
		}
		System.out.println(productDTO);
		productService.saveOrupdate(productDTO);
		return "redirect:/all-products";

	}

	

	@RequestMapping(value = "all-products", method = RequestMethod.GET)
	public ModelAndView getAllProducts() {
		List<ProductDTO> allproducts = productService.getProducts();
		for (ProductDTO product : allproducts) {
			System.out.println(allproducts);
		}

		ModelAndView view = new ModelAndView();
		view.addObject("productList", allproducts);
		view.setViewName("products");
		return view;
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public String removeData(@RequestParam("id") Integer id) {
		productService.delete(id);
		return "redirect:/all-products";
	}
	
	
	@RequestMapping(value = "/editProduct",method = RequestMethod.GET)
	public ModelAndView updateProduct(@RequestParam Integer id) {
		if(id!=null) {
			ProductDTO product = productService.get(id);
			ModelAndView view = new ModelAndView();
			view.addObject("productDTO",product);
			view.setViewName("product");
			return view;
		}
		
		return null;
		
	}
	

}
