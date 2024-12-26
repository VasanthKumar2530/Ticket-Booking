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

import com.ticketbooking.bookingticket.Service.BookingService;
import com.ticketbooking.bookingticket.entity.Booking;
import com.ticketbooking.bookingticket.util.ResponseStructure;
@RestController
@RequestMapping("booking")
public class BookingRestController {
	@Autowired
   BookingService bookingService;
	@PostMapping
    public ResponseEntity<ResponseStructure<Booking>> save(@RequestBody Booking booking) {
    	return bookingService.save(booking);
    }
	@GetMapping
    public ResponseEntity<ResponseStructure<Booking>> findbyid(@RequestParam int id) {
    	return bookingService.findbyId(id); 
    }
	@GetMapping("all")
      public ResponseEntity<ResponseStructure<List<Booking>>> findAll() {    
    	return bookingService.findbyall();
    }
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Booking>> deletebyid(int id)
	{
		
		return bookingService.deletebyid(id);
		
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Booking>> updatebyid(@RequestParam int id,@RequestBody Booking booking )
	{
		return bookingService.update(id, booking);
		
	}
}
