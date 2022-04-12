package com.example.customer.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto {

	
	private UUID id;
	private String name;
	private String email;
	
	public CustomerDto(String name, String email) {
		this.name = name;
		this.email = email;
	}

}
