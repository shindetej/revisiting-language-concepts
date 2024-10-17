package com.tms.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteDemo {
	public static void main(String[] args) {
		try(BufferedWriter bw =  new BufferedWriter(new FileWriter("FileIO.md"))) {
			bw.write("FILE IO Concepts");
			bw.newLine();
			bw.write("R/W file in ");
			bw.newLine();
			bw.write("Java nio  operations for above same ");
			bw.newLine();
			bw.write("Move copu delete files operations ");
			System.out.println("File written successfully.");
		}catch(IOException e) {
			System.out.println("Exception occurred : "+e.getMessage());
		}
	}
}
