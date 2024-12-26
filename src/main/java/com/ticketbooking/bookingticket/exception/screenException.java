package com.ticketbooking.bookingticket.exception;

public class screenException extends RuntimeException {
	private	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public screenException(String message) {
		super();
		this.message = message;
	}


}
