package com.storepoints.apiportfolio.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidTotalAllocationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public InvalidTotalAllocationException(String message){
		super(message);
	}
	
}
