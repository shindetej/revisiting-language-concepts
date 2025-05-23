package com.tejas.logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class FileLoggerImpl implements Logger {
	private String logFilePath;
	
	@PostConstruct
	public void postBeanInit() {
		System.out.println("In FileLoggerImpl() ");
	}
	
	public FileLoggerImpl() {
		
		this.logFilePath = "application.log";
	}

	

	public String getLogFilePath() {
		return logFilePath;
	}



	public void setLogFilePath(String logFilePath) {
		this.logFilePath = logFilePath;
	}



	@Override
	public void log(String message) {
		try(FileOutputStream fos =  new FileOutputStream(this.logFilePath,true)){
			PrintStream ps =  new PrintStream(fos);
			ps.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())+ ": "+ message);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	
}
