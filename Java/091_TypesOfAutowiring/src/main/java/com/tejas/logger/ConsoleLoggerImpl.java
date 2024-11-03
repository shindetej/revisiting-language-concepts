package com.tejas.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component("consoleLogger")
public class ConsoleLoggerImpl implements Logger {
	
	@PostConstruct
	public void myInit() {
		System.out.println("IN ConsoleLoggerImpl.myInit()");
	}
	
	@Override
	public void log(String message) {
		System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())+": "+message);
		
	}

}
