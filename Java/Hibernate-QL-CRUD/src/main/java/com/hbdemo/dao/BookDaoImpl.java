package com.hbdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hbdemo.Utils.HBUtils;
import com.hbdemo.model.Book;

import jakarta.persistence.Query;

public class BookDaoImpl {
	private SessionFactory factory;

	public BookDaoImpl() {
		factory = HBUtils.getSessionFactory();
	}

	public void save(Book book) {
		Session session = factory.getCurrentSession();
		session.persist(book);
	}
	public Book getById(int id) {
		Session session = factory.getCurrentSession();
		return session.find(Book.class, id);
	}
	
	
	public List<Book> getByCategory(String category) {
		Session session = factory.getCurrentSession();
		String hq = "from Book b where b.category = :category";
		
		Query  query =  session.createQuery(hq,Book.class);
		query.setParameter("category", category);
		return query.getResultList();
	}
}
