package com.xworkz.poc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.QueryProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.cj.Query;
import com.xworkz.poc.entity.POCEntity;

@Component
public class POCDaoImpl implements POCDao{

	@Autowired
	private SessionFactory factory;
	
	
	
	
	public POCDaoImpl() {
		System.out.println(getClass().getSimpleName()+"Object si created of DaoImple");
	}




	public boolean savePOC(POCEntity pocEntity) {

		System.out.println("Save is Started");
		Session session=this.factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(pocEntity);
			transaction.commit();
			System.out.println("data is saved ");
			return true;
		}catch (Exception e) {

		
			session.getTransaction().rollback();
			System.out.println("data is rolled back");
		}finally {
			if(session !=null) {
				System.out.println("session is closed");
				session.close();
			}
			else {
				System.out.println("session is not closed");
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
