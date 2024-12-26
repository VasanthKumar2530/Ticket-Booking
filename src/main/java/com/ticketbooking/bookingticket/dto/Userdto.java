package com.ticketbooking.bookingticket.dto;

public class Userdto {
	  private int userId;
      private String userName;
      private String userEmail;
      private long userContact;
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
	@Override
	public String toString() {
		return "Userdto [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userContact="
				+ userContact + "]";
	}
      
}
