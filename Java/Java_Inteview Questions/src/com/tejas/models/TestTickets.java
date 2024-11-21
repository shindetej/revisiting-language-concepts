package com.tejas.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestTickets {

	public static void main(String[] args) {

		List<Ticket> ticketList = new ArrayList<>(Arrays.asList(new Ticket(101, "Tejas", LocalDate.of(2024, 11, 12)),
				new Ticket(102, "Abhinav", LocalDate.of(2024, 11, 16)),
				new Ticket(103, "Shantanu", LocalDate.of(2024, 11, 2)),
				new Ticket(104, "Kaustubh", LocalDate.of(2024, 11, 5)),
				new Ticket(105, "Tejas", LocalDate.of(2024, 11, 12)),
				new Ticket(106, "Kaustubh", LocalDate.of(2024, 11, 16)),
				new Ticket(107, "Kaustubh", LocalDate.of(2024, 11, 16))));
		
		
		getTicketsAssignedToEmployeeToday(ticketList);

	}

	public static void getTicketsAssignedToEmployeeToday(List<Ticket> list) {
		System.out.println("\nGet Tickets Done By Each Employee Today ");
		
		// Java 8 way
//		list.stream()
//		.filter(ticket->ticket.getUpdatedDate().equals(LocalDate.now()))
//		.collect(Collectors.groupingBy( (Ticket t)->t.getEmpName() ,Collectors.counting())) // Lambda expression used
//				.forEach((K,V)-> System.out.println(K + " : "+ V));
		
		
		list.stream()
		.filter(ticket->ticket.getUpdatedDate().equals(LocalDate.now()))
		.collect(Collectors.groupingBy( Ticket::getEmpName ,Collectors.counting())) // method refere	nce
		.forEach((K,V)-> System.out.println(K + " : "+ V));
		
		
		
		
	}

}
