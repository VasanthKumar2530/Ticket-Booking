package com.ticketbooking.bookingticket.exception;

public class bookingexception extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public bookingexception(String message) {
		super();
		this.message = message;
	}


}
