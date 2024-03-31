package com.microservices.eureka.app.items.models.service;

import java.util.List;

import com.microservices.eureka.app.items.models.entity.Item;

public interface ItemService {

	public List<Item> findAll();
	public Item findById(Long id, Integer cantidad);
}
