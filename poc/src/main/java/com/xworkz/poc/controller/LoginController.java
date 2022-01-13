package com.xworkz.poc.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.poc.service.POCService;
import com.xworkz.poc.util.MailDispatcher;
import com.xworkz.poc.util.OtpGenerator;

@Controller
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);

	private static Integer otppNumber;
	@Autowired
	private MailDispatcher mailDispatcher;
	@Autowired
	private POCService pocService;

	public LoginController() {

		logger.debug(getClass().getSimpleName() + "register Object controller created");
		// System.out.println(getClass().getSimpleName()+"register Object controller
		// created");
	}

	@RequestMapping(value = "/login.do")
	public String onLogin(@RequestParam String username, @RequestParam String password, Model model) {
		// System.out.println("invoking login method");
		logger.info("invoking login method");
		boolean loginSuccessful = this.pocService.loginService(username, password, model);
		if (loginSuccessful) {
			model.addAttribute("msg", "We have sent an otp to your emailId");

			otppNumber = OtpGenerator.randomNumberGenerator(1000, 9999);
			boolean outcome = this.mailDispatcher.SendOTP(username, "OTP_Message",
					"Hi Your OTP for XworkzPOC is: " + otppNumber);
			model.addAttribute("OtpSuccessMessage", "Your Otp sent to mail id");
			logger.info("OTP is generated");
			if (outcome) {
				return "login";
			} else {
				model.addAttribute("OtpSuccessMessage", "invalid email");
			}
		} else {
			model.addAttribute("msg", " Login Failed your user & password wrong try again");
		}return "login";
		
		

	}

}
