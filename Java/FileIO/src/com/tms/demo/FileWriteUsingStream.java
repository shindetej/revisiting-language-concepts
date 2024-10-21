package com.tms.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileWriteUsingStream {

	public static void main(String[] args) {
		try(FileOutputStream fos =  new FileOutputStream("application.log", true)){
			PrintStream ps =  new PrintStream(fos);
			ps.println("Hello");
			ps.println("This demo is used for printing data using File output stream and Print stream");
			ps.println("END....");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
