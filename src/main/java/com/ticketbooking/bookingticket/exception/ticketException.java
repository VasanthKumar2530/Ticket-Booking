package com.ticketbooking.bookingticket.exception;

public class ticketException extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ticketException(String message) {
		super();
		this.message = message;
	}


}
