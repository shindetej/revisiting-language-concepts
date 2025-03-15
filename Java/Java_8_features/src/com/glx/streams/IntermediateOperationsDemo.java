package com.glx.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.glx.model.Customer;

/*
 * In this demo we will focusing on using all the intermediate operations
 *  */

public class IntermediateOperationsDemo {

	public static void main(String[] args) {
		// filter()

		List<Integer> numbers = Arrays.asList(1, 2, 4, 3, 9, 12, 44, 54);

		Predicate<Integer> pred1 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				return t % 2 != 0;
			}
		};
		System.out.println("List of numbers on which filter applied :" + numbers);
		System.out.println("filter() demo : all element which are divisible by 3 and not divide by 2(commented)");

		numbers.stream() // created stream
				.filter(n -> n % 3 == 0) // divide by 3
//				.filter(pred1) // not divide by 2 using predicate
				.forEach(System.out::println); // print using foreach

		// map()
		System.out.println("\n*********** map() demo *************\n:> map(s->s.toUppercase) use to create uppercase word list");
		List<String> flavours = Arrays.asList("mango", "Apple", "Pista", "Kesar");
		System.out.println("\nOriginal list of flavours : " + flavours);
		List<String> upperFlavours = flavours.stream().map(s -> s.toUpperCase()) // map() used to convert string to
																					// uppercase taking Function()
				.collect(Collectors.toList());
		System.out.println("After map used :: list of flavours : " + upperFlavours);

		// flatMap()
		/*
		 * flatMap(Function<T, Stream<R>>) flattens a nested structure into a single
		 * stream.
		 */
		System.out.println("\n*********** flatMap() demo *************\n:> create uniq subjects list from different courses");
		List<List<String>> studentCourses = Arrays.asList(Arrays.asList("Maths", "Physics", "Chemistry"),
				Arrays.asList("Economics", "Statistics", "Maths"), Arrays.asList("Marathi", "History", "Englist"));
		System.out.println("flatMap() demo : Before : nested list of subjects :: "+ studentCourses);
		Set<String> uniqueSubjects = studentCourses.stream()
											.flatMap(s-> s.stream()) // you can use List::stream
											.collect(Collectors.toSet());
		System.out.println("flatMap() demo : After : flatten set of subjects :: "+ uniqueSubjects);
		
		
		// Other example flatMap
		System.out.println("\n:>Flat map demo with customer class having orders list");
		List<Customer> customers = Arrays.asList(
				new Customer("Raj",Arrays.asList("Mobile","Watch")),
				new Customer("Teja",Arrays.asList("Laptop","Tata Namak"))
				);
		List<String> productList = customers.stream()
											.flatMap(cust->cust.getOrders().stream())
											.toList();
		System.out.println("List of products fetched from orders : "+productList);
		
		
		// distinct()
		System.out.println("\n*********** distinct() demo *************\n:> Removes duplicate elements from the stream based on equals().");
		List<Integer> nums = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
		System.out.print(":> List of distinct items from : "+nums + " -----> ");
		nums.stream()
			.distinct()
				.toList().forEach(s -> System.out.print(s+" "));
		
		// sorted
		System.out.println("\n*********** sorted() demo *************\n:> Sorts elements in natural order (Comparable) or using a custom comparator.");

		List<Integer> unsortedList1 = Arrays.asList(5, 21, 13, 41, 58, 26);
		List<Integer> unsortedList2 = Arrays.asList(5, 21, 13, 41, 58, 26);
		
		System.out.println("Ascending sorted stream : ");
		unsortedList1.stream().sorted().toList().forEach(System.out::println); // sorted ascending order
		System.out.println("Descending sorted stream : ");
		unsortedList2.stream().sorted(Comparator.reverseOrder()).toList().forEach(System.out::println); // sorted reversed / descending order
		
		// limit(Long)
		System.out.println("\n*********** limit() demo *************\n:> Restricts the stream to the first n element here 4");

		Stream<Integer> infStream  =  Stream.iterate(1, i->i+1);
		infStream.limit(4).toList().forEach(System.out::println);

		// skip
		System.out.println("\n*********** skip() demo *************\n:> Skips the first n elements and processes the rest.");

		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> skipped = numbers1.stream()
		    .skip(3) // 1st 3 skip
		    .collect(Collectors.toList());

		System.out.println("After skipping 1st 3 elements "+skipped); // Output: [4, 5, 6]

		// peek<Consumer<T>)
		System.out.println("\n*********** peek() demo *************\n:>  allows performing an action without modifying the stream.");

		List<String> list = Arrays.asList("Rajesh","Anil","Harsha");
		
		List<String> output = list.stream().peek(person->System.out.println("peek to : "+person)).map(m->m.toUpperCase()).toList();
		System.out.println("OUTPUT : "+output);
		
		// *****************************
	}
}
