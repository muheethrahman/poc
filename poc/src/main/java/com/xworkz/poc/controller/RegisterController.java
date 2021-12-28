package com.xworkz.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.poc.dao.POCDao;
import com.xworkz.poc.dto.POCDto;
import com.xworkz.poc.service.POCService;

@Controller
public class RegisterController {

	@Autowired
	private POCService service;

	public RegisterController() {
		
		System.out.println(getClass().getSimpleName()+"register Object controller created");
		
	}
	
	@RequestMapping(value = "/clickregister.do")
	public String onClickRegister() {
		return "login";

	}
	
	@RequestMapping(value="/register.do")
	public String deatailsRegister(@ModelAttribute POCDto dto,Model model ) {
		
		System.out.println("invoked DetealisRegistered mehtod controller");
		System.out.println(dto);
		boolean outcome=this.service.registers(dto);
		if(outcome) {
			model.addAttribute("msg","registeration is successful");
			return "login";
		}
		
		else {
			model.addAttribute("msg","registeration not successfull");
			return "register";
		}
		
	}
	
	
}
