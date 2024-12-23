### How to handle exceptions in spring boot web application
- Why : to give proper response even if exception occurs due to
    - invalid query parameters
    - missing parameters
#### 1. Create custom exceptions if needed :
```java
public class InvalidOrderIdException extends RuntimeException{
    super(message);
}
```
####  create dto for error response
```java
public class ErrorDetails {
	private LocalDateTime timestamp;
	private String message;
	private String  details;
	
	public ErrorDetails() {
		
	}
// getter setters
}
```
#### create global exception handler
```java

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidOrderIdException.class)
	public ResponseEntity<ErrorDetails> handleInvalidOrderException(InvalidOrderIdException ex) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getLocalizedMessage(), ex.getMessage());

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
```
