package com.ticketbooking.bookingticket.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Seat {

	 @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
private int seatId;
	 private int screenId;
	 private String seatNumber;
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", screenId=" + screenId + ", seatNumber=" + seatNumber + "]";
	}
	
}
