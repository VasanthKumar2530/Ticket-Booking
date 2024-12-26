package com.ticketbooking.bookingticket.exception;

public class movieshowException extends RuntimeException {
	private	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public movieshowException(String message) {
		super();
		this.message = message;
	}


}
