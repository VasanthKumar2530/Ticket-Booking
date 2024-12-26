package com.ticketbooking.bookingticket.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Theatre {
	 @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int theatreId;
	 private String theatreName;
     @OneToOne(cascade=CascadeType.ALL)       
     private Location location;
     @OneToMany(cascade=CascadeType.ALL)       
     private List<Screen> screen;
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public List<Screen> getScreen() {
		return screen;
	}
	public void setScreen(List<Screen> screen) {
		this.screen = screen;
	}
	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", location=" + location
				+ ", screen=" + screen + "]";
	}
     
	
	
     
}
