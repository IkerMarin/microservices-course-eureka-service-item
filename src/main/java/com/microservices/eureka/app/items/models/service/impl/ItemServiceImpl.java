package com.microservices.eureka.app.items.models.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.eureka.app.items.models.entity.Item;
import com.microservices.eureka.app.items.models.entity.Product;
import com.microservices.eureka.app.items.models.service.ItemService;

@Service
@Primary
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate restClient;
	
	@Override
	public List<Item> findAll() {
		List<Product> productos = Arrays.asList(restClient.getForObject("http://localhost:8001/products/product-list", Product[].class));
		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Product producto = restClient.getForObject("http://localhost:8001/products/{id}", Product.class, pathVariables);
		return new Item(producto, cantidad);
	}

}
