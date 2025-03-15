package com.glx.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LearningStream1 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Alice","Bob","Charlie","Aaron","Marie","Chen","Mahi");
		// ********** STREAM PIPELINE STRUCTURE ****
		System.out.println("********** STREAM PIPELINE STRUCTURE : create,intermediate operations,terminal operations *****");
		// creating stream
		Stream<String> stream = names.stream();
		
		// intermediate operation
		Stream<String> filteredStream = stream.filter(name->name.startsWith("C"));
		
		// terminal opertaion to produce /execute result
		List<String> result = filteredStream.collect(Collectors.toList());
		
		
		// can be done in one line
		List<String> resultMNames=  names.stream().filter(name->name.startsWith("M")).collect(Collectors.toList());
		System.out.println("Result with C started names : "+result);
		System.out.println("Result with M started names : "+resultMNames);
		
		
		// **********************
		
		// creating stream from arrays
		
		
//		IntStream intList = (IntStream) Arrays.asList(1,2,2,3,4,52,3,12);
//		intList.average().of(0)
		
		System.out.println("\nInt stream 3 : filter applied divide by 3 numbers ,sorted reversed,for each printed ");
		Stream<Integer> intStream3 = Arrays.asList(5,21,3,11,4,12).stream();
		intStream3.filter(n->n%3 ==0)
			.collect(Collectors.toList())
				.stream()
					.sorted(Comparator.reverseOrder()).forEach(s->System.out.print("> "+s));
		
		System.out.println("Create stream using Arrays.stream() ::  used sorted order and limit result to 4");
		Stream<Integer> intStream1 =  Arrays.stream(new Integer[] {14,2,11,44,22});
		intStream1.sorted(Comparator.reverseOrder()).limit(4).forEach(System.out::println);
		
		System.out.println("\nInt using iterate method");
		Stream<Integer> intStream2 = Stream.iterate(1, n->n+1);
		intStream2.limit(7).forEach(System.out::println);
		
		

		
		
	}

}
