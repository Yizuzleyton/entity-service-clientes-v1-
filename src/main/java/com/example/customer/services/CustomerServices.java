package com.example.customer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.example.customer.dto.CustomerDto;
import com.example.customer.dto.ResponseDataDto;
import com.example.customer.entities.Customer;
import com.example.customer.util.CustomerUtil;

@Service
public class CustomerServices {
	private List<Customer> customers = new ArrayList<>();
	private String message = "";
	
	public ResponseDataDto<List<CustomerDto>> findAll() {
		try {
			
			List<CustomerDto> listDto = CustomerUtil.entityToDtoList(customers);
			message = customers.size() > 0 ? "Se encontraron clientes." : "No hay clientes registrados.";
			return new ResponseDataDto<>(true, 200, message, listDto);
	
		} catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseDataDto<>(false, 500, "Ocurrio un error.");
		}
	}
	
	public ResponseDataDto<List<CustomerDto>> addCustomer(CustomerDto dto) {
		try {
			Customer newCustomer = CustomerUtil.dtoToEntity(dto);
			newCustomer.setId(UUID.randomUUID());
			Boolean resp = customers.add(newCustomer);
			message = resp ? "Se registro el cliente exitosamente." : "Algo salio mal, favor de intentar de nuevo."; 
			return new ResponseDataDto<>(true,200, message, CustomerUtil.entityToDtoList(customers));
	
		} catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseDataDto<>(false, 500, "Ocurrio un error.");
		}
	}
	
	public ResponseDataDto<List<CustomerDto>> updateCustomer(CustomerDto dto) {
		try {

			Integer index = IntStream.range(0, customers.size())
									 .filter(i -> customers.get(i).getId().equals(dto.getId()))
									 .findFirst().orElse(-1);
			
			if(!index.equals(-1))
			customers.set(index, CustomerUtil.dtoToEntityUpdate(dto));
			
			message = index.equals(-1) ? "favor de validar el cliente." : "Se edito con exito el cliente."; 
			return new ResponseDataDto<>(true,200, message, CustomerUtil.entityToDtoList(customers));
	
		} catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseDataDto<>(false, 500, "Ocurrio un error.");
		}
	} 

	
	public ResponseDataDto<List<CustomerDto>> deleteCustomer(UUID id) {
		try {
			
			Boolean resp = customers.removeIf(c -> c.getId().equals(id));
			message = resp ? "Se elimino el cliente exitosamente." : "favor de validar el cliente.";
			return new ResponseDataDto<>(true, 200, message, CustomerUtil.entityToDtoList(customers));
	
		} catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseDataDto<>(false, 500, "Ocurrio un error.");
		}
	} 
}
