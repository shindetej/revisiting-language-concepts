package com.practice.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeAPIDemo1 {

	public static void main(String[] args) {
			
		LocalTime localTime = LocalTime.now();
		System.out.println("Local Time : "+localTime);
		LocalDate localDate = LocalDate.now();
		System.out.println("Local Date : "+localDate);
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Local Date Time : "+localDateTime);
		
		// get formatted date using date time formatter pattern
		DateTimeFormatter format =  DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss");
		DateTimeFormatter format1 =  DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		System.out.println("Date time in our format :dd-MMM-yyyy hh:mm:ss :  "+localDateTime.format(format));
		
		
		// get specified date
		LocalDate date = LocalDate.of(1987, 12, 29);
		System.out.println(date.format(format1));
		System.out.println("Get date after 10 days from now : "+ LocalDate.now().plusDays(10));
		
		ZoneId zone = ZoneId.of("America/New_York");
		System.out.println(ZonedDateTime.now(zone).format(format));
		
	}

}
