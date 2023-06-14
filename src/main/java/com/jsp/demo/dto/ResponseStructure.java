package com.jsp.demo.dto;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	private int statuscode;
	private String message;
	private T data;
}
