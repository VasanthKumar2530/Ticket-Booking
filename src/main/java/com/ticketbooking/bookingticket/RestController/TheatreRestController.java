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

import com.ticketbooking.bookingticket.Service.TheatreService;
import com.ticketbooking.bookingticket.entity.Theatre;
import com.ticketbooking.bookingticket.util.ResponseStructure;

@RestController
@RequestMapping("theatre")
public class TheatreRestController {
	@Autowired
	TheatreService Theatreservice;
	@PostMapping
    public ResponseEntity<ResponseStructure<Theatre>> save(@RequestBody Theatre Theatre) {
    	return Theatreservice.save(Theatre);
    }
	@GetMapping
    public ResponseEntity<ResponseStructure<Theatre>> findbyid(@RequestParam int id) {
    	return Theatreservice.findbyId(id); 
    }
	@GetMapping("all")
      public ResponseEntity<ResponseStructure<List<Theatre>>> findAll() {    
    	return Theatreservice.findbyall();
    }

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Theatre>> deletebyid(int id)
	{
		
		return Theatreservice.deletebyid(id);
		
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Theatre>> updatebyid(@RequestParam int id,@RequestBody Theatre theatre )
	{
		return Theatreservice.update(id, theatre);
		
	}
}
