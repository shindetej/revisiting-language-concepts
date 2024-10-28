package com.tejas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Rectangle rect1() {
		Rectangle rect= new Rectangle();
		rect.setBreadth(4);
		rect.setLength(5);
		return rect;
	}
	
	@Bean
	public Rectangle rect2() {
		return new Rectangle(20,10);
	}
}
