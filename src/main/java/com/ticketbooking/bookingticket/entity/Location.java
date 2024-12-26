package com.ticketbooking.bookingticket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Location {
	 @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
private int locationId;
private String streetName;
private String landMark;
private int pincode;
public int getLocationId() {
	return locationId;
}
public void setLocationId(int locationId) {
	this.locationId = locationId;
}
public String getStreetName() {
	return streetName;
}
public void setStreetName(String streetName) {
	this.streetName = streetName;
}
public String getLandMark() {
	return landMark;
}
public void setLandMark(String landMark) {
	this.landMark = landMark;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
@Override
public String toString() {
	return "Location [locationId=" + locationId + ", streetName=" + streetName + ", landMark=" + landMark + ", pincode="
			+ pincode + "]";
}


}
