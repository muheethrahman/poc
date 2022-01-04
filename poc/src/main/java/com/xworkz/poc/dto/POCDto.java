package com.xworkz.poc.dto;

public class POCDto {


	private String username;
	private String password;
	private String confirm;
	private String country;
	private String state;
	private String city;
	private int pincode;
	private long phone;
	


	public POCDto(String username, String password, String confirm, String country, String state, String city,
			int pincode, long phone) {
		super();
		this.username = username;
		this.password = password;
		this.confirm = confirm;
		this.country = country;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.phone = phone;
	}


	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getconfirm() {
		return confirm;
	}

	public void setconfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	
	
	
	
}
