package com.xworkz.poc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.poc.dao.POCDao;
import com.xworkz.poc.dto.POCDto;
import com.xworkz.poc.entity.POCEntity;

@Service
public class POCServiceImpl implements POCService {
	
	private  Logger logger = 
			LoggerFactory.getLogger(POCServiceImpl.class);
	@Autowired
	private POCDao dao;
	
	

	public POCServiceImpl() {
		logger.debug(getClass().getSimpleName()+"register Object controller created");
	}



	public boolean registers(POCDto pocDto) throws NestedRuntimeException{

		logger.debug("register invoked");
		POCEntity entity=new POCEntity();
		BeanUtils.copyProperties(pocDto, entity);
		boolean result=this.dao.savePOC(entity);
		if(result) {
			logger.debug("done");
			return true;
		}
		else {
			logger.debug("OOps something went wrongs");
		}
		
		return false;
	}



	@Override
	public boolean loginService(String username, String password, Model model) {
		
		System.out.println("Invoked loging service");
		POCEntity entity=this.dao.getEmailByEntity(username, password);
		if(entity != null && !entity.getUsername().isEmpty() && entity.getUsername() != null
				&& !entity.getPassword().isEmpty()) {
		
			return true;
		} else {
			return false;
		}
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
