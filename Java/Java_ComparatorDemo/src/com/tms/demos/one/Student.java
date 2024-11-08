package com.tms.demos.one;

public class Student {
	int age;
	String grade;
	String name;

	public Student(int age, String grade, String name) {
		this.age = age;
		this.grade = grade;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		
		return "\nSTUDENT NAME : "+ this.name + " , AGE : "+this.age+" GRADE : "+this.grade;
	}

}
