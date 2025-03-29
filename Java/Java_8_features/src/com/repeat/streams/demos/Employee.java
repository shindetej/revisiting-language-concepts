package com.repeat.streams.demos;

import java.util.ArrayList;
import java.util.List;

class Employee {
	int empId;
	String name;
	int age;
	String department;
	double salary;

	public Employee(int empId, String name, int age, String department, double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.department = department;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", department=" + department
				+ ", salary=" + salary + "]";
	}

	public static List<Employee> getEmployeeTestList() {

		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee(101, "Alice", 25, "IT", 60000));
		employees.add(new Employee(102, "Bob", 28, "HR", 55000));
		employees.add(new Employee(103, "Charlie", 30, "Finance", 75000));
		employees.add(new Employee(104, "David", 35, "Marketing", 72000));
		employees.add(new Employee(105, "Eve", 27, "IT", 58000));
		employees.add(new Employee(106, "Frank", 29, "HR", 53000));
		employees.add(new Employee(107, "Grace", 30, "Finance", 77000));
		employees.add(new Employee(108, "Alice", 32, "Marketing", 68000)); // Duplicate name
		employees.add(new Employee(109, "Hank", 31, "IT", 62000));
		employees.add(new Employee(110, "Ivy", 28, "HR", 54000));
		employees.add(new Employee(111, "Jack", 35, "Finance", 80000));
		employees.add(new Employee(112, "Kevin", 27, "Marketing", 59000));
		employees.add(new Employee(113, "Liam", 30, "IT", 61000));
		employees.add(new Employee(114, "Mia", 29, "Finance", 76000));

		// Print all employees
		return employees;
	}

}
