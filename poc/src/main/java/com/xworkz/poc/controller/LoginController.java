package com.xworkz.poc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.poc.service.POCService;

@Controller
public class LoginController {
	private  Logger logger = 
			LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private POCService pocService;

	public LoginController() {
	
		logger.debug(getClass().getSimpleName()+"register Object controller created");
	}
	
	@RequestMapping(value="/login.do")
	public String onLogin(@RequestParam String username,@RequestParam String password,Model model) {
		
		logger.debug("invoking login method");
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
