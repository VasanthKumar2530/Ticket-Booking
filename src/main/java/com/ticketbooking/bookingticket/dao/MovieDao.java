package com.ticketbooking.bookingticket.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticketbooking.bookingticket.entity.Movie;
import com.ticketbooking.bookingticket.repository.MovieRepository;

@Repository
public class MovieDao {
	@Autowired
	MovieRepository movieRepository;
	public Movie save(Movie Movie) {
	
		return movieRepository.save(Movie);
		
	}
	public List<Movie> findallMovie() {
		return movieRepository.findAll(); 
		
	}
  public Movie findById(int id) {
	 Optional<Movie> Movie= movieRepository.findById(id);
	 if(Movie.isPresent()) {
		 return Movie.get();
	 }
	 return null;
  }
  
  public  List<Movie> findbyname(String movieName) {
	  List<Movie> Movie= movieRepository.findBymovieName(movieName);
		 if(Movie!=null) {
			 return Movie;
		 }
		 return null;
  }
  public Movie update(int id,Movie Movie) {
	   Movie movie=findById(id);
	   if(movie!=null) {
		   Movie.setMovieId(id);
		  return movieRepository.save(Movie);
	   }
	   return null;
  }

  public Movie delete(int id) {
	   Movie Movie=findById(id);
	   if(Movie!=null) {
	  movieRepository.delete(Movie);
	  return Movie;
	   }
	   return null;
  }

}
