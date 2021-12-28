package com.xworkz.poc.service;

import org.springframework.ui.Model;

import com.xworkz.poc.dto.POCDto;

public interface POCService {

	public boolean registers(POCDto pocDto);
	public boolean loginService(String email , String Password , Model model);
}
