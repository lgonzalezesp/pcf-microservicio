package com.example.client.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.apache.log4j.Logger;


@Service
public class ProductService {

	private RestTemplate restTemplate;
	
	static Logger log = Logger.getLogger(ProductService.class.getName());
	
	@Value("${product.service.host}")
	private String product_service_host;
	
	public ProductService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<Product> getProducts() {
		ParameterizedTypeReference<List<Product>> parameterizedTypeReference = new ParameterizedTypeReference<List<Product>>() {
		};
		
		log.info(" product_service_host " + product_service_host + "v1/product" );
		
		List<Product> products = restTemplate
				.exchange(product_service_host + "v1/product", HttpMethod.GET, null, parameterizedTypeReference)
				.getBody();
		return products;
	}

}