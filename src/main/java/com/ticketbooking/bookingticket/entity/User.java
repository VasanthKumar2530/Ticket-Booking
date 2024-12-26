package com.ticketbooking.bookingticket.entity;

import jakarta.persistence.Entity;
import lombok.Data;


import jakarta.persistence.*;

@Entity
@Data
public class User {
       @Id
       @GeneratedValue(strategy=GenerationType.IDENTITY)
       private int userId;
       private String userName;
       private String userEmail;
       private long userContact;
       private String userPassword;      
       private String confirmuserPassword;

@OneToOne(cascade=CascadeType.ALL)       
       private Booking booking;

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getUserEmail() {
	return userEmail;
}

public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}

public long getUserContact() {
	return userContact;
}

public void setUserContact(long userContact) {
	this.userContact = userContact;
}

public String getUserPassword() {
	return userPassword;
}

public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}

public String getConfirmuserPassword() {
	return confirmuserPassword;
}

public void setConfirmuserPassword(String confirmuserPassword) {
	this.confirmuserPassword = confirmuserPassword;
}

public Booking getBooking() {
	return booking;
}

public void setBooking(Booking booking) {
	this.booking = booking;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userContact="
			+ userContact + ", userPassword=" + userPassword + ", confirmuserPassword=" + confirmuserPassword
			+  "]";
}
	
}
