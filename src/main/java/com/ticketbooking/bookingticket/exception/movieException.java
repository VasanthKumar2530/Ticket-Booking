package com.ticketbooking.bookingticket.exception;

public class movieException extends RuntimeException {
	private	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public movieException(String message) {
		super();
		this.message = message;
	}


}
