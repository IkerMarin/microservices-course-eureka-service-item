package com.microservices.eureka.app.items.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.eureka.app.items.clientes.ProductClientRest;
import com.microservices.eureka.app.items.models.entity.Item;

@Service("serviceFeign")
public class ItemServiceFeign implements ItemService {
	
	@Autowired
	private ProductClientRest clienteFeign;

	@Override
	public List<Item> findAll() {
		return clienteFeign.getProductList().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.getProductDetail(id), cantidad);
	}

}
