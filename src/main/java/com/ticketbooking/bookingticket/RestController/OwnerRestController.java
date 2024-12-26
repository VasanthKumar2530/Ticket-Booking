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

import com.ticketbooking.bookingticket.Service.OwnerService;
import com.ticketbooking.bookingticket.dto.Admindto;
import com.ticketbooking.bookingticket.entity.Admin;
import com.ticketbooking.bookingticket.util.ResponseStructure;

@RestController
@RequestMapping("admin")
public class OwnerRestController {
	@Autowired
	OwnerService Ownerservice;
	@PostMapping
    public ResponseEntity<ResponseStructure<Admin>> save(@RequestBody Admin Owner) {
    	return Ownerservice.save(Owner);
    }
	@GetMapping
    public ResponseEntity<ResponseStructure<Admindto>> findbyid(@RequestParam int id) {
    	return Ownerservice.findbyId(id); 
    }
	@GetMapping("all")
      public ResponseEntity<ResponseStructure<List<Admin>>> findAll() {    
    	return Ownerservice.findbyall();
    }
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Admindto>> deletebyid(int id)
	{
		
		return Ownerservice.deletebyid(id);
		
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Admindto>> updatebyid(@RequestParam int id,@RequestBody Admin owner )
	{
		return Ownerservice.update(id, owner);
		
	}
}
