package com.ticketbooking.bookingticket.entity;

import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Screen {
	 @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int sreenId;
	 
	 private String screenName;
	 
//	 private int totalseats;
	 @ElementCollection
	 private Map<String,Boolean> map;
	 
     @ManyToOne(cascade=CascadeType.ALL)       
     private Theatre theatre;

     @OneToMany(cascade=CascadeType.ALL)       
      private List<Movieshow> Movieshow;
     
     @OneToMany(cascade=CascadeType.ALL)       
     private List<Seat> seat;

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

	public Map<String, Boolean> getMap() {
		return map;
	}

	public void setMap(Map<String, Boolean> map) {
		this.map = map;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public List<Movieshow> getMovieshow() {
		return Movieshow;
	}

	public void setMovieshow(List<Movieshow> movieshow) {
		Movieshow = movieshow;
	}

	public List<Seat> getSeat() {
		return seat;
	}

	public void setSeat(List<Seat> seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Screen [sreenId=" + sreenId + ", screenName=" + screenName + ", map=" + map + ", theatre=" + theatre
				+ ", Movieshow=" + Movieshow + ", seat=" + seat + "]";
	}


   
	}

