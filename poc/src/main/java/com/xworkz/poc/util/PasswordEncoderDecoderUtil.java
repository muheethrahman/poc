package com.xworkz.poc.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderDecoderUtil {
	//private static  Logger logger = 
			//LoggerFactory.getLogger(PasswordEncoderDecoderUtil.class);

	public static String encodePassword(String rawPassword) {
		//logger.debug("Invoked encodePassword() from PasswordEncoderDecoderUtil");
System.out.println("password encryption");
		BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
		return bcryptEncoder.encode(rawPassword);

	}



}
