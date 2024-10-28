package com.tejas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.tejas.model.Author;
import com.tejas.model.AuthorImpl;
import com.tejas.model.Book;
import com.tejas.model.BookImpl;

@Configuration
@Import(AuthorImpl.class)
public class AppConfig {
	

	@Bean
	public Book b1() {
		Book b = new BookImpl();
		
		b.setBookName("Srivalli");
		b.setPrice(193);
		return b;
	}

//	@Bean
//	public Author a1() {
//		Author teja =  new AuthorImpl();
//		teja.setEmail("teja@gmail.com");
//		teja.setMobile("4300239122");
//		teja.setName("Teja S");
//		return teja;
//	}

}
