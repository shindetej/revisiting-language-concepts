package com.tejas.srp;

import java.io.FileWriter;
import java.io.IOException;

// EmployeeFileManager handles file operations. 
class EmployeeFileManager {
	public void saveToFile(Employee employee, String filename) {
		try (FileWriter writer = new FileWriter(filename)) {
			writer.write("Name: " + employee.getName() + ", Department: " + employee.getDepartment());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/*
 * If the file-saving logic changes, you modify only EmployeeFileManager,
 * keeping the Employee class untouched.
 */
