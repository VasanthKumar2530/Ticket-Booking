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

import com.ticketbooking.bookingticket.Service.SeatService;
import com.ticketbooking.bookingticket.entity.Seat;
import com.ticketbooking.bookingticket.util.ResponseStructure;

@RestController
@RequestMapping("seat")
public class SeatRestController {
	@Autowired
	SeatService Seatservice;
	@PostMapping
    public ResponseEntity<ResponseStructure<Seat>> save(@RequestBody Seat Seat) {
    	return Seatservice.save(Seat);
    }
	@GetMapping
    public ResponseEntity<ResponseStructure<Seat>> findbyid(@RequestParam int id) {
    	return Seatservice.findbyId(id); 
    }
	@GetMapping("all")
      public ResponseEntity<ResponseStructure<List<Seat>>> findAll() {    
    	return Seatservice.findbyall();
    }
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Seat>> deletebyid(int id)
	{
		
		return Seatservice.deletebyid(id);
		
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Seat>> updatebyid(@RequestParam int id,@RequestBody Seat seat )
	{
		return Seatservice.update(id, seat);
		
	}
}
