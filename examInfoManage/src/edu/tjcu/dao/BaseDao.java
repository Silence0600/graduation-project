package edu.tjcu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**
 * 所有DAO的父类
 * @author Steve
 *
 */
public class BaseDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
