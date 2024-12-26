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

import com.ticketbooking.bookingticket.Service.TicketService;
import com.ticketbooking.bookingticket.entity.Ticket;
import com.ticketbooking.bookingticket.util.ResponseStructure;

@RestController
@RequestMapping("ticket")
public class TicketRestController {
	@Autowired
	TicketService Ticketservice;
	@PostMapping
    public ResponseEntity<ResponseStructure<Ticket>> save(@RequestBody Ticket Ticket) {
    	return Ticketservice.save(Ticket);
    }
	@GetMapping
    public ResponseEntity<ResponseStructure<Ticket>> findbyid(@RequestParam int id) {
    	return Ticketservice.findbyId(id); 
    }
	@GetMapping("all")
      public ResponseEntity<ResponseStructure<List<Ticket>>> findAll() {    
    	return Ticketservice.findbyall();
    }
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Ticket>> deletebyid(int id)
	{
		
		return Ticketservice.deletebyid(id);
		
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Ticket>> updatebyid(@RequestParam int id,@RequestBody Ticket ticket )
	{
		return Ticketservice.update(id, ticket);
		
	}
}
