package com.ticketbooking.bookingticket.exception;

public class locationException extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public locationException(String message) {
		super();
		this.message = message;
	}


}
