package edu.expert.ai.pulman.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HibernateManager
{
	private static final Logger log	= LoggerFactory.getLogger(HibernateManager.class);
	
	private static SessionFactory sessionFactory;
	
	public static Session getSession()
	{
		if (sessionFactory == null)
		{
			synchronized (HibernateManager.class)
			{
				if (sessionFactory == null)
				{
					try
					{
						log.info("Creating new Content SessionFactory");
						sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
						
					}
					catch (Throwable ex)
					{
						log.error("Initial Content SessionFactory creation failed.", ex);
						throw new ExceptionInInitializerError(ex);
					}
				}
			}
		}
		return sessionFactory.openSession();
	}

}
