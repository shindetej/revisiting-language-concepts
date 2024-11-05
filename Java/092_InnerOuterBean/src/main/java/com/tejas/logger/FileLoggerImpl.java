package com.tejas.logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component("fileLogger")
@PropertySource({"classpath:demo.properties" })
@Primary
public class FileLoggerImpl implements Logger {
	
	@Value("${log.filepath}")
	private String logFilePath;
	
	@PostConstruct
	public void postBeanInit() {
		System.out.println("In FileLoggerImpl post construct ");
	}
	
	public FileLoggerImpl() {
		System.out.println("In FileLoggerImpl() ");
		this.logFilePath = "application.log";
	}

	

	public String getLogFilePath() {
		return logFilePath;
	}



	public void setLogFilePath(String logFilePath) {
		this.logFilePath = logFilePath;
	}



	@Override
	public void log(String mesage) {
		try(FileOutputStream fos =  new FileOutputStream(this.logFilePath,true)){
			PrintStream ps =  new PrintStream(fos);
			ps.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())+ ": "+ mesage);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	
}
