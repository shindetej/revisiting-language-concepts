package com.tejas.demo1;

import java.util.Objects;

public class Person {
	String name;
	int age;
	double contact;
	
	public Person(String name, int age,double contact) {
		super();
		this.name = name;
		this.age = age;
		this.contact = contact;
		
	}
	@Override
	public int hashCode() {
//		return Objects.hash(age, name);
		System.out.println("Inside hashcode() : " + Objects.hash(name) );
		return Objects.hash(age,name,contact);
//		return Objects.hash(contact);
	}
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		System.out.println("Inside equals() :  are object already same and equal  : "+ (age==other.age && name.equals(other.name) &&  contact == other.contact));
		return age==other.age && name.equals(other.name) &&  contact == other.contact;
//		return age == other.age && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	

}
