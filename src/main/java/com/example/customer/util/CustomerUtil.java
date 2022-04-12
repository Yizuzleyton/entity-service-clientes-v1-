package com.example.customer.util;

import java.util.List;
import java.util.stream.Collectors;

import com.example.customer.dto.CustomerDto;
import com.example.customer.entities.Customer;

public class CustomerUtil {
	
	public static List<CustomerDto> entityToDtoList(List<Customer> listCustomer){
		return listCustomer.stream().map(c -> entityToDto(c)).collect(Collectors.toList());
	}
	
	public static Customer dtoToEntity(CustomerDto dto) {
		return new Customer(dto.getName(), dto.getEmail());
	}
	
	public static Customer dtoToEntityUpdate(CustomerDto dto) {
		return new Customer(dto.getId(),dto.getName(), dto.getEmail());
	}
	
	public static CustomerDto entityToDto(Customer entity) {
		return new CustomerDto(entity.getId(), entity.getName(), entity.getEmail());
	}
}
