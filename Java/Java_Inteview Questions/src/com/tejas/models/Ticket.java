package com.tejas.models;

import java.time.LocalDate;
import java.util.Date;

public class Ticket implements Comparable<Ticket> {

	double ticketId;
	String empName;
	LocalDate updatedDate;
	
	public Ticket(double ticketId, String empName, LocalDate dateOfTicket) {
		super();
		this.ticketId = ticketId;
		this.empName = empName;
		this.updatedDate = dateOfTicket;
	}
	public double getTicketId() {
		return ticketId;
	}
	public void setTicketId(double ticketId) {
		this.ticketId = ticketId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

	
	@Override
	public String toString() {
		return "{ticketId=" + ticketId + ", empName=" + empName + ", updatedDate=" + updatedDate + "}";
	}
	
	@Override
	public int compareTo(Ticket o) {
		return Double.compare(this.ticketId, o.ticketId);
	}
	
}
