package com.jpa.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jpa.demo.responses.Response;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidOrderIdException.class)
	public ResponseEntity<ErrorDetails> handleInvalidOrderException(InvalidOrderIdException ex) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getLocalizedMessage(), ex.getMessage());

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleEntityNotFoundException(EntityNotFoundException ex) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getLocalizedMessage(),
				"Entity Not Found");

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
