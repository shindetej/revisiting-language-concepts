package com.tms.srp;

import java.io.FileWriter;
import java.io.IOException;

// SRP VIOLATION  : The Employee class is responsible for two things: 
//managing employee data and saving it to a file.
class EmployeeSRPFailed {
    private String name;
    private String department;

    public EmployeeSRPFailed(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    // Handles saving to file (violates SRP)
    public void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Name: " + name + ", Department: " + department);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

