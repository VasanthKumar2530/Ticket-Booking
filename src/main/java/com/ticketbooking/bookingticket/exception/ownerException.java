package com.ticketbooking.bookingticket.exception;

public class ownerException extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ownerException(String message) {
		super();
		this.message = message;
	}


}
