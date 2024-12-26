package com.ticketbooking.bookingticket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Movieshow {
	 @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
private int showId;
private int movieId;
private int theatreId;
private int screenId;
private String showTime;

public int getShowId() {
	return showId;
}

public void setShowId(int showId) {
	this.showId = showId;
}

public int getMovieId() {
	return movieId;
}

public void setMovieId(int movieId) {
	this.movieId = movieId;
}

public int getTheatreId() {
	return theatreId;
}

public void setTheatreId(int theatreId) {
	this.theatreId = theatreId;
}

public int getScreenId() {
	return screenId;
}

public void setScreenId(int screenId) {
	this.screenId = screenId;
}

public String getShowTime() {
	return showTime;
}

public void setShowTime(String showTime) {
	this.showTime = showTime;
}

@Override
public String toString() {
	return "Movieshow [showId=" + showId + ", movieId=" + movieId + ", theatreId=" + theatreId + ", screenId="
			+ screenId + ", showTime=" + showTime + "]";
}


}
