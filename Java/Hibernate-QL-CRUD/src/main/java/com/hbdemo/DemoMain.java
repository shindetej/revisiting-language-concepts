package com.hbdemo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import com.hbdemo.Utils.HBUtils;
import com.hbdemo.dao.BookDaoImpl;
import com.hbdemo.model.Book;

public class DemoMain {

	public static void main(String[] args) {
		BookDaoImpl bookDao = new BookDaoImpl();
		System.out.println("INSERT");
//		try {
//			HBUtils.beginTransaction();
//			Book b1 = new Book("ANSI C Programming Language", "K & R", 450.0, 4.2f, new Date(), "Programming");
//			Book b2 = new Book("Sapiens", "Yuval Noah Harari", 990.0, 4.5f,
//					Date.from(LocalDate.of(2012, 12, 9).atStartOfDay(ZoneId.systemDefault()).toInstant()), "History");
//			Book b3 = new Book("Fountain Head", "Ayn Rand", 390.0, 3.5f,
//					Date.from(LocalDate.of(1957, 5, 9).atStartOfDay(ZoneId.systemDefault()).toInstant()), "Fiction");
//			Book b5 = new Book("Siddhartha", "Herman Hesse", 190.0, 3.2f,
//					Date.from(LocalDate.of(1920, 11, 19).atStartOfDay(ZoneId.systemDefault()).toInstant()), "Fiction");
//			Book b4 = new Book("Java Complete Reference", "Herbert Schildt", 1990.0, 4.2f,
//					Date.from(LocalDate.of(2009, 1, 25).atStartOfDay(ZoneId.systemDefault()).toInstant()),
//					"Programming");
//			bookDao.save(b1);
//			bookDao.save(b2);
//			bookDao.save(b3);
//			bookDao.save(b4);
//			bookDao.save(b5);
//			HBUtils.commitTransaction();
//		} catch (Exception e) {
//			HBUtils.rollBackTransaction();
//		}	
//		
//		try {
//			HBUtils.beginTransaction();
//			Book book = bookDao.getById(2);
//			System.out.println(book);
//			HBUtils.commitTransaction();
//		} catch (Exception e) {
//			HBUtils.rollBackTransaction();
//		}
		
		
		try {
			System.out.println("HI");
			HBUtils.beginTransaction();
			List<Book> bookList = bookDao.getByCategory("Fiction");
			System.out.println(bookList);
			HBUtils.commitTransaction();
		} catch (Exception e) {
			System.out.println("Broke");
			HBUtils.rollBackTransaction();
		}
	}
}
