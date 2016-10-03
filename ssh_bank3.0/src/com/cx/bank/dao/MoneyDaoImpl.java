package com.cx.bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cx.bank.model.MoneyBean;

/**
 * 持久bean，用于操作数据库
 * 
 * @author 许望禄
 * 
 */
public class MoneyDaoImpl implements MoneyDao {
	
	private SessionFactory sessionFactory;


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean insert(MoneyBean mb) {
		Session session = sessionFactory.openSession();
		try {
			session.save(mb);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public MoneyBean query(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from MoneyBean  where userName=:name").setParameter("name", name);
		@SuppressWarnings("unchecked")
		List<MoneyBean>list = query.list();
		if(list!=null){
			try{
				@SuppressWarnings("unused")
				MoneyBean mb= list.get(0);
			}catch(Exception e){
				return null;
			}
			return list.get(0);
		}
		return null;
	}

	public boolean update(MoneyBean mb) {
		Session session = sessionFactory.openSession();
		try {
			session.update(mb);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
