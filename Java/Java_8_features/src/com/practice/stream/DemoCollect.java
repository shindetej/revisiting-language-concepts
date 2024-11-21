package com.practice.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DemoCollect {

	public static void main(String[] args) {
		List<Employee> list = Employee.getEmployeeList();

		System.out.println(list);
		// collect() API USE : Transforms each element of the stream into another form,
		// typically used to extract fields or convert data types.
		System.out.println("USE OF Collector : GIVE NAME OF EMPLOYEES");
		// The Collector interface is used to accumulate elements of a stream into a

		Collector<Employee, StringBuilder, String> nameCollector = Collector.of(StringBuilder::new, // supplier: create
																									// new SB
				(sb, emp) -> sb.append(emp.getName()).append(", "), // accumulator: append each name with a comma
				StringBuilder::append, // combiner: merge two StringBuilder instances
				sb -> sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "" // finisher: remove the last comma
		);
		// Using the custom collector
		String result = list.stream().collect(nameCollector);
		System.out.println(result);

		System.out.println("USE OF Collectors : Salary wise Count of Employees");
		Map<Double, Long> salariesCount = list.stream().collect(Collectors.groupingBy(Employee::getSalary,Collectors.counting()));
		salariesCount.entrySet().forEach(System.out::println);
	}

}
