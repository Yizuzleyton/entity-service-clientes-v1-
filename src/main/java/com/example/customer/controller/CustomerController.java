package com.example.customer.controller;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.dto.CustomerDto;
import com.example.customer.dto.ResponseDataDto;
import com.example.customer.services.CustomerServices;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private CustomerServices customerService;
	
	@GetMapping()
	public ResponseDataDto<List<CustomerDto>> findAll(){
		return customerService.findAll();
	}
	
	@PostMapping()
	public ResponseDataDto<List<CustomerDto>> addCustomer(@RequestBody CustomerDto dto){
		return customerService.addCustomer(dto);
	}
	
	@PutMapping()
	public ResponseDataDto<List<CustomerDto>> updateCustomer(@RequestBody CustomerDto dto) {
		return customerService.updateCustomer(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseDataDto<List<CustomerDto>> deleteCustomer(@PathVariable UUID id){
		return customerService.deleteCustomer(id);
	}
}
