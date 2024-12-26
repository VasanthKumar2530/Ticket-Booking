package com.ticketbooking.bookingticket.exception;


public class userException extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public userException(String message) {
		super();
		this.message = message;
	}

}
