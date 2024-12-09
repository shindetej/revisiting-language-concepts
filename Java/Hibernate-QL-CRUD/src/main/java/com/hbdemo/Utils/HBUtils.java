package com.hbdemo.Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HBUtils {

	private static SessionFactory sessionFactory = createSessionFactory();

	private static ServiceRegistry serviceRegistry;

	private static SessionFactory createSessionFactory() {
		serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

		Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();

		return metadata.getSessionFactoryBuilder().build();
	}

	public static void shutdown() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
		if (serviceRegistry != null) {
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void beginTransaction() {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
	}
	
	public static void commitTransaction() {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().commit();
	}
	
	public static void rollBackTransaction() {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().rollback();
	}

}
