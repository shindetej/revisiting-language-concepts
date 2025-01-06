package com.practice.sorting;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Employee {
	private int empId;
	private String name;
	private double salary;
	private LocalDate dateOfJoining;

	public Employee(int empId, String name, double salary, LocalDate dateOfJoining) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + ", dateOfJoining=" + dateOfJoining
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfJoining, empId, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dateOfJoining, other.dateOfJoining) && empId == other.empId && name == other.name
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	public static List<Employee> getEmployeeList() {
		List<Employee> empList = Arrays.asList(new Employee(1012, "Raj Maher", 56000, LocalDate.of(2021, 6, 1)),
				new Employee(901, "Kunti Shah", 78000, LocalDate.of(2019, 12, 24)),
				new Employee(1540, "Yuval Gupta", 46000, LocalDate.of(2023, 6, 18)),
				new Employee(1100, "Sagar Patil", 86000, LocalDate.of(2021, 7, 06)));

		return empList;
	}

}