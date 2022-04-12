package com.example.customer.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResponseDataDto<T> {

	private Boolean status;
	private Integer code;
	private String message;
	private T body;
	
	public ResponseDataDto(Boolean status, Integer code, String message, T body) {
		this.status = status;
		this.code = code;
		this.message = message;
		this.body = body;
	}
	

	public ResponseDataDto(Boolean status, Integer code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}
