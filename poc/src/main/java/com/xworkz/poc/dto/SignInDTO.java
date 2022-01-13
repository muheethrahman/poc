package com.xworkz.poc.dto;

public class SignInDTO { 
	
	private String user;
	private int otp;
	
	public SignInDTO(String user, int otp) {
		super();
		this.user = user;
		this.otp = otp;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}
	
	

}
