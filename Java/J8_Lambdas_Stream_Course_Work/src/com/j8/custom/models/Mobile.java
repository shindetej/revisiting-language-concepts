package com.j8.custom.models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Mobile {
	String make;
	String model;
	int memory;
	String color;
	double rating;
	double price;
	LocalDate launchDate;

	public Mobile(String make, String model, int memory, String color, double rating, double price,
			LocalDate launchDate) {
		this.make = make;
		this.model = model;
		this.memory = memory;
		this.color = color;
		this.rating = rating;
		this.price = price;
		this.launchDate = launchDate;
	}
	
	
	

	public String getMake() {
		return make;
	}




	public String getModel() {
		return model;
	}




	public int getMemory() {
		return memory;
	}




	public String getColor() {
		return color;
	}




	public double getRating() {
		return rating;
	}




	public double getPrice() {
		return price;
	}




	public LocalDate getLaunchDate() {
		return launchDate;
	}




	@Override
	public String toString() {
		return "Mobile{" + "make='" + make + '\'' + ", model='" + model + '\'' + ", memory=" + memory + ", color='"
				+ color + '\'' + ", rating=" + rating + ", price=" + price + ", launchDate=" + launchDate + '}';
	}


	public static List<Mobile> getMobilesList()
	{
		return Arrays.asList(new Mobile("Apple", "iPhone 14", 128, "Black", 4.8, 79999, LocalDate.of(2022, 9, 16)),
				new Mobile("Samsung", "Galaxy S22", 256, "White", 4.7, 64999, LocalDate.of(2022, 2, 9)),
				new Mobile("Google", "Pixel 7", 128, "Obsidian", 4.6, 45999, LocalDate.of(2022, 10, 6)),
				new Mobile("OnePlus", "10 Pro", 256, "Green", 4.5, 58999, LocalDate.of(2022, 3, 31)),
				new Mobile("Xiaomi", "Mi 12", 128, "Blue", 4.4, 49999, LocalDate.of(2022, 12, 15)),
				new Mobile("Apple", "iPhone 13", 128, "Black", 4.7, 69999, LocalDate.of(2021, 9, 24)),
				new Mobile("Samsung", "Galaxy S21", 256, "White", 4.6, 54999, LocalDate.of(2021, 1, 14)),
				new Mobile("Apple", "iPhone 12", 128, "Red", 4.5, 59999, LocalDate.of(2020, 10, 23)),
				new Mobile("Samsung", "Galaxy S20", 128, "Gray", 4.4, 47999, LocalDate.of(2020, 2, 11)),
				new Mobile("Xiaomi", "Mi 11", 256, "Blue", 4.3, 43999, LocalDate.of(2021, 3, 29)));
	}
}
