package com.example.client.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.client.service.Product;
import com.example.client.service.ProductService;

@Controller
public class HomeController {
	
	public HomeController(ProductService productService) {
		this.productService = productService;
	}
	
	private ProductService productService;
	@GetMapping("/")
	public String home(Model model) {
		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);
		return "index";
	}

}