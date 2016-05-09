package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil  {
	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSesssionFactory() {
		try{
			// A SessionFactory is set up once for an application
			sessionFactory = new Configuration()
              .configure("resources/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
              .buildSessionFactory();
		}
		catch(Throwable ex){
			System.err.println("Session Factory creation failed: " + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return sessionFactory;
	}
}
