package com.xworkz.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.poc.service.POCService;

@Controller
public class LoginController {
	
	@Autowired
	private POCService pocService;

	public LoginController() {
	
		System.out.println(getClass().getSimpleName()+"object of login is created");
	}
	
	@RequestMapping(value="/login.do")
	public String onLogin(@RequestParam String username,@RequestParam String password,Model model) {
		
		System.out.println("invoking login method");
		boolean loginSuccessful=this.pocService.loginService(username, password, model);
		if (loginSuccessful) {
			model.addAttribute("msg", "your account login succesfullly done");
			return "success";
		} else {
			model.addAttribute("msg", " Login Failed your user & password wrong try again later");
			return "fail";
		}
		
		
		
	}

}
