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
public class Movie {
	 @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
      private int movieId;
	 private String movieName;
	 private String duration;
	 private String language;
     @OneToMany(cascade=CascadeType.ALL)       
    private List<Movieshow> Movieshow;
     @OneToMany(cascade=CascadeType.ALL)       
     private List<Screen> screen;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public List<Movieshow> getMovieshow() {
		return Movieshow;
	}
	public void setMovieshow(List<Movieshow> movieshow) {
		Movieshow = movieshow;
	}
	public List<Screen> getScreen() {
		return screen;
	}
	public void setScreen(List<Screen> screen) {
		this.screen = screen;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", duration=" + duration + ", language="
				+ language + ", show=" + Movieshow + ", screen=" + screen + "]";
	}
	
}
