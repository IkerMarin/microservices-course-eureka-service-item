package com.microservices.eureka.app.items.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.eureka.app.items.models.entity.Product;

@FeignClient(name = "products-service", url="localhost:8001")
public interface ProductClientRest {
	
	@GetMapping("/products/product-list")
	public List<Product> getProductList();
	
	@GetMapping("/products/{id}")
	public Product getProductDetail(@PathVariable Long id);

}
