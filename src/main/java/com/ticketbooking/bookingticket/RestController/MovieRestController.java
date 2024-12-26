package com.ticketbooking.bookingticket.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.bookingticket.Service.MovieService;
import com.ticketbooking.bookingticket.entity.Movie;
import com.ticketbooking.bookingticket.util.ResponseStructure;

@RestController
@RequestMapping("movie")
public class MovieRestController {
	@Autowired
	MovieService Movieservice;
	@PostMapping
    public ResponseEntity<ResponseStructure<Movie>> save(@RequestBody Movie Movie) {
    	return Movieservice.save(Movie);
    }
	@GetMapping
    public ResponseEntity<ResponseStructure<Movie>> findbyid(@RequestParam int id) {
    	return Movieservice.findbyId(id); 
    }
	@GetMapping("all")
      public ResponseEntity<ResponseStructure<List<Movie>>> findAll() {    
    	return Movieservice.findbyall();
    }
	@GetMapping("byname")
    public ResponseEntity<ResponseStructure<List<Movie>>> findbyname(@RequestParam String name) {
    	return Movieservice.findbyname(name); 
    }
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Movie>> deletebyid(int id)
	{
		
		return Movieservice.deletebyid(id);
		
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Movie>> updatebyid(@RequestParam int id,@RequestBody Movie movie )
	{
		return Movieservice.update(id, movie);
		
	}
}
