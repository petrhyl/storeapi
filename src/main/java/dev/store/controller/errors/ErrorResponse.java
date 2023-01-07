package dev.store.controller.errors;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse
{
	public ErrorResponse(HttpStatus status, LocalDateTime timeStamp, String message)
	{
		this.status = status;
		this.timeStamp = timeStamp;
		this.message = message;
	}

	public ErrorResponse(HttpStatus status, String message)
	{
		this.status = status;
		this.message = message;
		this.timeStamp = LocalDateTime.now();
	}

	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime timeStamp;
	private String message;

	public HttpStatus getStatus()
	{
		return status;
	}

	public LocalDateTime getTimeStamp()
	{
		return timeStamp;
	}

	public String getMessage()
	{
		return message;
	}
}
