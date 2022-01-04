package com.xworkz.poc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.QueryProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.cj.Query;
import com.xworkz.poc.controller.LoginController;
import com.xworkz.poc.entity.POCEntity;

@Component
public class POCDaoImpl implements POCDao{
	private  Logger logger = 
			LoggerFactory.getLogger(POCDaoImpl.class);

	@Autowired
	private SessionFactory factory;
	
	
	
	
	public POCDaoImpl() {
		logger.debug(getClass().getSimpleName()+"register Object controller created");
	}




	public boolean savePOC(POCEntity pocEntity) {

		logger.debug("Save is Started");
		Session session=this.factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(pocEntity);
			transaction.commit();
			logger.debug("data is saved ");
			return true;
		}catch (Exception e) {

		
			session.getTransaction().rollback();
			logger.debug("data is rolled back");
		}finally {
			if(session !=null) {
				logger.debug("session is closed");
				session.close();
			}
			else {
				logger.debug("session is not closed");
			}
		}
		
		return false;
	}




	@Override
	public POCEntity getEmailByEntity(String username, String password) {
		
		System.out.println("getEmail id dao method");
		POCEntity entity=null;
		Object session=null;
		try {
			session=this.factory.openSession();
			org.hibernate.query.Query query=((QueryProducer)session).createNamedQuery("GetRecord");
			query.setParameter("em",username);
			query.setParameter("e",password);
			entity=(POCEntity) query.uniqueResult();
			return entity;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("You have an exception " + e.getMessage());
			return null;
		} finally {
			if (session != null) {
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		
	}
	}

}
