package com.storepoints.apiportfolio.exception;

public class ErrorDetails {

	private String errorCode;

	public ErrorDetails(String errorCode){
		this.errorCode=errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
