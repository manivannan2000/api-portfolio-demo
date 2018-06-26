package com.storepoints.apiportfolio.model;

public class AdvisorCreateRequest {
	
	private String name;
	
	private String loginId;
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}
