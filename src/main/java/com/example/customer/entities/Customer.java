package com.example.customer.entities;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {

	private UUID id;
	private String name;
	private String email;
	
	public Customer(String name, String email) {
		this.name = name;
		this.email = email;
	}
}
