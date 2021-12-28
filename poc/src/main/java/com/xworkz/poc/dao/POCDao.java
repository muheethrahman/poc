package com.xworkz.poc.dao;

import com.xworkz.poc.entity.POCEntity;

public interface POCDao {

	public boolean savePOC(POCEntity pocEntity);
	POCEntity getEmailByEntity(String email,String password);
	
}
