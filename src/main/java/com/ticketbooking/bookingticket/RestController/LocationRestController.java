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

import com.ticketbooking.bookingticket.Service.Locationservice;
import com.ticketbooking.bookingticket.entity.Location;
import com.ticketbooking.bookingticket.util.ResponseStructure;

@RestController
@RequestMapping("location")
public class LocationRestController {
	@Autowired
	Locationservice Locationservice;
	@PostMapping
    public ResponseEntity<ResponseStructure<Location>> save(@RequestBody Location Location) {
    	return Locationservice.save(Location);
    }
	@GetMapping
    public ResponseEntity<ResponseStructure<Location>> findbyid(@RequestParam int id) {
    	return Locationservice.findbyId(id); 
    }
	@GetMapping("all")
      public ResponseEntity<ResponseStructure<List<Location>>> findAll() {    
    	return Locationservice.findbyall();
    }
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Location>> deletebyid(int id)
	{
		
		return Locationservice.deletebyid(id);
		
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Location>> updatebyid(@RequestParam int id,@RequestBody Location location )
	{
		return Locationservice.update(id, location);
		
	}
}
