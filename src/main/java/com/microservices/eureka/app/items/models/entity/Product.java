package com.microservices.eureka.app.items.models.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Product {
	
	private Long id;
	private String name;
	private Double price;
	private LocalDate creationDate;
	private Integer port;
	
}
