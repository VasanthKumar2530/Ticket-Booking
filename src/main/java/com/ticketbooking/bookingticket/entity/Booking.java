package com.ticketbooking.bookingticket.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Booking {
	  @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      private int bookingId;
      private String showId;
      private String bookingSeats;
      @OneToOne(cascade=CascadeType.ALL)       
      private User user;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getShowId() {
		return showId;
	}
	public void setShowId(String showId) {
		this.showId = showId;
	}
	public String getBookingSeats() {
		return bookingSeats;
	}
	public void setBookingSeats(String bookingSeats) {
		this.bookingSeats = bookingSeats;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", showId=" + showId + ", bookingSeats=" + bookingSeats + ", user="
				+ user + "]";
	}

}
