package com.xworkz.poc.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.poc.dao.POCDao;
import com.xworkz.poc.dto.POCDto;
import com.xworkz.poc.entity.POCEntity;
import com.xworkz.poc.util.MailDispatcher;
import com.xworkz.poc.util.PasswordEncoderDecoderUtil;

@Service
public class POCServiceImpl implements POCService {
	
	private static final Logger logger=Logger.getLogger(POCServiceImpl.class);
	@Autowired
	private POCDao dao;
	@Autowired
	private MailDispatcher mailDispatcher;
	

	public POCServiceImpl() {
		logger.debug(getClass().getSimpleName()+"register Object controller created");
		//System.out.println(getClass().getSimpleName()+"register Object controller created");
	}



	public boolean registers(POCDto pocDto) throws NestedRuntimeException {
//System.out.println("register invoked");
		logger.info("register invoked");
		POCEntity entity=new POCEntity();
		String userpassword=pocDto.getPassword();
		
		String encrypt= PasswordEncoderDecoderUtil.encodePassword(userpassword);
		
		BeanUtils.copyProperties(pocDto, entity);
		entity.setPassword(encrypt);
//System.out.println(entity.getPassword());
		boolean result=this.dao.savePOC(entity);
		if(result) {
		logger.info("done");
			//System.out.println("done");
		this.mailDispatcher.SendOTP(pocDto.getUsername(), "Your Registeration is Successfully",
				"LogIn using link : http://localhost:8080/poc/clickregister.do  ");
			return true;
		}
		else {
			logger.info("OOps something went wrongs");
			//System.out.println("oops");
		}
		
		return false;
	}



	@Override
	public boolean loginService(String username, String password, Model model) {
		//System.out.println("invoked loging");
		logger.info("Invoked loging service");
	
		POCEntity entity=this.dao.getEmailByEntity(username, password);
		  //raw-password,db-password
		boolean passwordCheck = PasswordEncoderDecoderUtil.decodePassword( password,entity.getPassword());
		                                                             
		                                                   
	if(passwordCheck) {
			return true;
		} else {
			logger.info(passwordCheck);
			return false;
		}
//	}
//		return false;
	}
	
	



	@Override
	public boolean loginEmailAndPasswordValidate(String username, String password) {
		if (!username.isEmpty() && username != null && password != null && !password.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
