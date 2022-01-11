package com.xworkz.poc.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.poc.entity.POCEntity;

@Component
public class POCDaoImpl implements POCDao{
	private static final Logger logger=Logger.getLogger(POCDaoImpl.class);

	@Autowired
	private SessionFactory factory;
	
	
	
	
	public POCDaoImpl() {
		//System.out.println(getClass().getSimpleName()+"register Object controller created");
		logger.debug(getClass().getSimpleName()+"register Object controller created");
	}




	public boolean savePOC(POCEntity pocEntity) {
//System.out.println("save is stared");
		logger.info("Save is Started");
		Session session=this.factory.openSession();
		try {
		
			Transaction transaction = session.beginTransaction();
			logger.info("session is transaction");
			session.save(pocEntity);
			logger.info("saved in entity");
			transaction.commit();
			//System.out.println("data is saved");
			logger.debug("data is saved ");
			return true;
		}catch (Exception e) {

		
			session.getTransaction().rollback();
			logger.info("data is rolled back");
			//System.out.println("roooled back");
		}finally {
			if(session !=null) {
				//System.out.println("session closed");
				logger.info("session is closed");
				session.close();
			}
			else {
				logger.info("session is not closed");
				//System.out.println();
			}
		}
		
		return false;
	}




	@Override
	public POCEntity getEmailByEntity(String username, String password) {
	
		POCEntity entity=null;
	Session session=null;
		try {
			
			session=this.factory.openSession();
			
			Query query=session.createNamedQuery("GetRecord");
			query.setParameter("em",username);
			
			entity=(POCEntity) query.uniqueResult();
			return entity;
		}catch (Exception e) {
			e.printStackTrace();
			logger.info("You have an exception " + e.getMessage());
			return null;
		} finally {
			if (session != null) {
			logger.info("Session is closed");
			} else {
				logger.info("Session is not closed");
			}
		
	}
	}

}
