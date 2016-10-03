package com.cx.bank.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cx.bank.model.Log;

public class LoggerServiceImpl implements LoggerService {
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void createLogTable(String tableName) {
		
	}

	public void saveLogger(Log log) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(log);
		session.getTransaction().commit();
		
	}
	
}
