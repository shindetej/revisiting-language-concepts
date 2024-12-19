package com.jpa.demo.exceptions;

public class InvalidOrderIdException extends RuntimeException {
	public InvalidOrderIdException(String message) {
		super(message);
	}
}
