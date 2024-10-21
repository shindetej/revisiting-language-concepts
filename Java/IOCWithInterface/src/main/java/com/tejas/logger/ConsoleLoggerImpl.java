package com.tejas.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLoggerImpl implements Logger {
	

	@Override
	public void log(String message) {
		System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())+": "+message);
		
	}

}
