package com.xworkz.poc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.poc.service.POCService;
import com.xworkz.poc.util.MailDispatcher;
import com.xworkz.poc.util.OtpGenerator;

@Controller
public class OtpController {

	private static final Logger logger = Logger.getLogger(OtpController.class);

	private static Integer otppNumber;
	@Autowired
	private MailDispatcher mailDispatcher;
	// @Autowired
	// private POCService pocService;

	public OtpController() {
		System.out.println(getClass().getSimpleName() + "-->object is created");
	}

//	@RequestMapping(value = "/startotp.do" , method={RequestMethod.GET, RequestMethod.POST})
//	public String getOtp(@PathVariable String username, Model model,HttpServletRequest req) {
//		logger.info("invoked getOTP");
//		otppNumber = OtpGenerator.randomNumberGenerator(1000, 9999);
//		boolean outcome=this.mailDispatcher.SendOTP(username, "OTP_Message", "Hi Your OTP for XworkzPOC is: "+otppNumber);
//		model.addAttribute("OtpSuccessMessage", "Your Otp sent to mail id");
//		logger.info("OTP is generated");
//		if(outcome) {
//			HttpSession session=req.getSession();
//			 session.setAttribute("email",username);
//			return "success";
//		}else {
//			model.addAttribute("OtpSuccessMessage", "invalid email");
//		}
//		return "startotp.do";
//	}
//
//	
//	}
	@RequestMapping(value = "/veriffyOtp.do")
	public String verifyOtp(@RequestParam Integer otpNumber, Model model) {
		System.out.println("invoked verifyOtp");
		Object object = otpNumber;
		System.out.println(object);
		if (otppNumber.equals(object.equals(object))) {
			model.addAttribute("msg", "valid otp");
			return "success";
		} else {
			model.addAttribute("msg", "invalid_otp try again later");

			return "fail";
		}

	}

}

//	
