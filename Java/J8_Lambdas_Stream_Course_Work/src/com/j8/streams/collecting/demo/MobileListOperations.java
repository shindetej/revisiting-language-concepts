/**
 * Created custom object Mobile which has basic attributes 
 * I am focusing on below concepts in demo
 * Grouping and Partitioning to create Map of grouped/partitioned element
 * operations like counting ,mapping,filtering ,aggregating,nesting group
 * demonstrated
 * also understood less used but good to know feature like joining ,reducing(similar to reduce())
 * go through demo for concepts
 * 
 * */



package com.j8.streams.collecting.demo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.j8.custom.models.Mobile;

public class MobileListOperations {
	public static void main(String[] args) {
		List<Mobile> mobiles = Mobile.getMobilesList();

		// groupingBy cases handled (counting,mapping,aggregate)
		getMobileCountByMake(mobiles);
//		getMobileModelGroupByMake(mobiles);
//		findMostExpensivePhoneOfEachMake(mobiles);
//		getMobilesWithMakeNColorGrouping(mobiles);

		// averagingDouble or averagingInt
		getAveragePriceOfAllMobiles(mobiles);

		// filtering applied with grouping by
		getHighRatingMobileByMake(mobiles);

		// use of joining()
		getModelsAvailable(mobiles);

		// use of reducing()
		getTotalMobilesPricing(mobiles);
		
		// use of flatmapping()
		
		getflattencolors(mobiles);
	}

	private static void getflattencolors(List<Mobile> mobiles) {
		Map<String, Set<String>>  map = mobiles.stream()
			.collect(Collectors.groupingBy(Mobile::getMake,
					Collectors.flatMapping(m->Stream.of(m.getColor()), Collectors.toSet())));
		
		System.out.println("Colors Available By Make: "+map);
		
	}

	private static void getTotalMobilesPricing(List<Mobile> mobiles) {
		Double price = mobiles.stream().map(Mobile::getPrice).collect(Collectors.reducing(Double::sum)).orElse(0.0);
			// same could be done by	//.reduce((a,b)->a+b).orElse(0.0);
		System.out.println("Total Price of all Mobiles: ₹"+price);
	}

	private static void getModelsAvailable(List<Mobile> mobiles) {
		String models = mobiles.stream().map(Mobile::getModel)
				.collect(Collectors.joining(", ", "Mobile Models Available : ", "."));
		System.out.println(models);
	}

	// GROUPING WITH COUNT
	private static void getAveragePriceOfAllMobiles(List<Mobile> mobiles) {
		// counting the number of mobiles for each make ?
		double averagePrice = mobiles.stream().collect(Collectors.averagingDouble(Mobile::getPrice));
		System.out.println("Average Price: ₹" + averagePrice);
	}

	private static void getHighRatingMobileByMake(List<Mobile> mobiles) {
		// counting the number of mobiles for each make ?
		Map<String, List<Mobile>> highRatedModelsByMake = mobiles.stream().collect(Collectors
				.groupingBy(Mobile::getMake, Collectors.filtering(r -> r.getRating() > 4.5, Collectors.toList())));
		System.out.println("High Rated Mobiles by Make: " + highRatedModelsByMake);
	}

	private static void getMobileCountByMake(List<Mobile> mobiles) {
		// counting the number of mobiles for each make ?
		Map<String, Long> mobileCountGroupByMake = mobiles.stream()
				.collect(Collectors.groupingBy(Mobile::getMake, Collectors.counting()));
		System.out.println(mobileCountGroupByMake);
	}

	// GROUPING WITH MAPPING FIELD (Model grouped by Make
	private static void getMobileModelGroupByMake(List<Mobile> mobiles) {
		// counting the number of mobiles for each make ?
		Map<String, List<String>> mobileCountGroupByMake = mobiles.stream().collect(
				Collectors.groupingBy(Mobile::getMake, Collectors.mapping(Mobile::getModel, Collectors.toList())));
		System.out.println(mobileCountGroupByMake);

	}

	// GROUPING WITH AGGREGATION (max,min)
	private static void findMostExpensivePhoneOfEachMake(List<Mobile> mobiles) {
		// counting the number of mobiles for each make ?
		Map<String, String> mobileCountGroupByMake = mobiles.stream()
				.collect(Collectors.groupingBy(Mobile::getMake,
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Mobile::getPrice)),
								op -> op.map(Mobile::getModel).orElse(null))));
		System.out.println(mobileCountGroupByMake);

	}

	// NESTED GROUPING
	private static void getMobilesWithMakeNColorGrouping(List<Mobile> mobiles) {
		Map<String, Map<String, List<Mobile>>> map = mobiles.stream().collect(
				Collectors.groupingBy(Mobile::getMake, Collectors.groupingBy(Mobile::getColor, Collectors.toList())));
		System.out.println("Get Mobiles With Make N Color Grouping");
		map.entrySet().forEach(s -> System.out.println("\t" + s.getKey() + "\n\t" + s.getValue()));
		;
	}
}
