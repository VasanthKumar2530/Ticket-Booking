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

import com.ticketbooking.bookingticket.Service.movieshowService;
import com.ticketbooking.bookingticket.entity.Movieshow;
import com.ticketbooking.bookingticket.util.ResponseStructure;

@RestController
@RequestMapping("show")
public class showRestController {
	@Autowired
	movieshowService Showservice;
	@PostMapping
    public ResponseEntity<ResponseStructure<Movieshow>> save(@RequestBody Movieshow Show) {
    	return Showservice.save(Show);
    }
	@GetMapping
    public ResponseEntity<ResponseStructure<Movieshow>> findbyid(@RequestParam int id) {
    	return Showservice.findbyId(id); 
    }
	@GetMapping("all")
      public ResponseEntity<ResponseStructure<List<Movieshow>>> findAll() {    
    	return Showservice.findbyall();
    }
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Movieshow>> deletebyid(int id)
	{
		
		return Showservice.deletebyid(id);
		
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Movieshow>> updatebyid(@RequestParam int id,@RequestBody Movieshow show )
	{
		return Showservice.update(id, show);
		
	}
}
