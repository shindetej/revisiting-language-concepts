package com.tejas.logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component("fileLogger")
public class FileLoggerImpl implements Logger {
	String loggerFilePath;

	public FileLoggerImpl() {
		this.loggerFilePath = "application.log";
	}

	public FileLoggerImpl(String loggerFilePath) {
		this.loggerFilePath = loggerFilePath;
	}
	

	public void setLoggerFilePath(String loggerFilePath) {
		this.loggerFilePath = loggerFilePath;
	}

	@Override
	public void log(String message) {
		try (FileOutputStream fos = new FileOutputStream(loggerFilePath)) {
			try(PrintStream ps = new PrintStream(fos, true)){
				
				ps.println(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm : ").format(LocalDateTime.now())+ message);
			}
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void init1() {
		System.out.println("In FileLoggerImpl Construct");
	}
}
