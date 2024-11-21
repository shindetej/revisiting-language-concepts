package com.tms.demos.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentUtils {

	public static List<Student> getList() {
		return Arrays.asList(new Student(12, "60", "Ajit Kalyan"), new Student(15, "65", "Eknath Shirke"),
				new Student(21, "85", "Sharad Fadanvis"), new Student(14, "45", "Zen Sadashiv"),
				new Student(4, "58", "Nilesh Lanke"));
	}

}
