package com.crudExample.demo.exception;
import java.util.Date;

public class CustomRestError {
	public CustomRestError(Date data, String message, String desc) {
		this.data = data;
		this.message = message;
		this.desc = desc;
	}
	
	Date data;
	String message;
	String desc;
}
