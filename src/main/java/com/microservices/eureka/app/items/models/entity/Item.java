package com.microservices.eureka.app.items.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Item {

	private Product product;
	private Integer amount;

	
	public Double getTotal() {
		return amount * product.getPrice();
	}
}
