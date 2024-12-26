package com.ticketbooking.bookingticket.exception;

public class seatException extends RuntimeException {
	private	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public seatException(String message) {
		super();
		this.message = message;
	}


}
