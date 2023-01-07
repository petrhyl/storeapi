package dev.store.controller.errors;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<Object> handleSqlIntegrityException(HttpServletRequest request,
			SQLIntegrityConstraintViolationException exception)
	{
		String errorMessage = "Unable to submit post: " + exception.getMessage();

		return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, errorMessage));
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElementException(HttpServletRequest request,
			NoSuchElementException exception)
	{
		String errorMessage = "The row for address does not exist: " + request.getRequestURI();
		ErrorResponse errorRes = new ErrorResponse(HttpStatus.NOT_FOUND, errorMessage);

		return buildResponseEntity(errorRes);
	}

	private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse)
	{
		return new ResponseEntity<Object>(errorResponse, errorResponse.getStatus());
	}
}
