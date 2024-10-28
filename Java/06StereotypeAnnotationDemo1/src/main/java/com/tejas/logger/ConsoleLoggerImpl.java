package com.tejas.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLoggerImpl implements Logger {
	
	public void log(String message) {
		System.out.println(DateTimeFormatter.ofPattern("yyyy-dd-MM hh:mm  :").format(LocalDateTime.now())  + message);
	}

}
