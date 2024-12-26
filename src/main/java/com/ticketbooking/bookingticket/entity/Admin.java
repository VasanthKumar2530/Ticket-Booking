package com.ticketbooking.bookingticket.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Admin {
	  @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      private int adminId;
      private String adminName;
      private String adminEmail;
      private String adminContact;
      private String adminPassword;      
      private String confirmadminPassword;
     	@OneToMany(cascade=CascadeType.ALL)       
private List<Theatre> theatre;
		public int getAdminId() {
			return adminId;
		}
		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}
		public String getAdminName() {
			return adminName;
		}
		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}
		public String getAdminEmail() {
			return adminEmail;
		}
		public void setAdminEmail(String adminEmail) {
			this.adminEmail = adminEmail;
		}
		public String getAdminContact() {
			return adminContact;
		}
		public void setAdminContact(String adminContact) {
			this.adminContact = adminContact;
		}
		public String getAdminPassword() {
			return adminPassword;
		}
		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}
		public String getConfirmadminPassword() {
			return confirmadminPassword;
		}
		public void setConfirmadminPassword(String confirmadminPassword) {
			this.confirmadminPassword = confirmadminPassword;
		}
		public List<Theatre> getTheatre() {
			return theatre;
		}
		public void setTheatre(List<Theatre> theatre) {
			this.theatre = theatre;
		}
     	
     	
}
	      

