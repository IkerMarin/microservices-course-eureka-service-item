package com.microservices.eureka.app.items.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.eureka.app.items.models.entity.Item;
import com.microservices.eureka.app.items.models.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/items/item-list")
	public List<Item> listar(){
		return itemService.findAll();
	}
	
	@GetMapping("/items/{id}/amount/{amount}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer amount) {
		return itemService.findById(id, amount);
	}

}
