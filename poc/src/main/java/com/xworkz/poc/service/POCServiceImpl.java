package com.xworkz.poc.service;

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
	
	@Autowired
	private POCDao dao;
	
	

	public POCServiceImpl() {
		System.out.println(getClass().getSimpleName()+"object is created serviceimp");
	}



	public boolean registers(POCDto pocDto) throws NestedRuntimeException{

		System.out.println("register invoked");
		POCEntity entity=new POCEntity();
		BeanUtils.copyProperties(pocDto, entity);
		boolean result=this.dao.savePOC(entity);
		if(result) {
			System.out.println("done");
			return true;
		}
		else {
			System.out.println("OOps something went wrongs");
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
