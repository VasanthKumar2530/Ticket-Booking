package com.ticketbooking.bookingticket.dto;

public class screendto {
	 private int sreenId;
	 
	 private String screenName;
	 
	 private int noOfSeats;

	public int getSreenId() {
		return sreenId;
	}

	public void setSreenId(int sreenId) {
		this.sreenId = sreenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	@Override
	public String toString() {
		return "screendto [sreenId=" + sreenId + ", screenName=" + screenName + ", noOfSeats=" + noOfSeats + "]";
	}
	 
}
