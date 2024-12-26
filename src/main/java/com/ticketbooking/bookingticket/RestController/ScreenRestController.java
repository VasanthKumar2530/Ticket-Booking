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

import com.ticketbooking.bookingticket.Service.ScreenService;
import com.ticketbooking.bookingticket.dto.screendto;
import com.ticketbooking.bookingticket.entity.Screen;
import com.ticketbooking.bookingticket.util.ResponseStructure;

@RestController
@RequestMapping("screen")
public class ScreenRestController {
	@Autowired
	ScreenService Screenservice;
	@PostMapping
    public ResponseEntity<ResponseStructure<Screen>> save(@RequestBody screendto Screen) {
    	return Screenservice.save(Screen);
    }
	@GetMapping
    public ResponseEntity<ResponseStructure<Screen>> findbyid(@RequestParam int id) {
    	return Screenservice.findbyId(id); 
    }
	@GetMapping("all")
      public ResponseEntity<ResponseStructure<List<Screen>>> findAll() {    
    	return Screenservice.findbyall();
    }
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Screen>> deletebyid(int id)
	{
		
		return Screenservice.deletebyid(id);
		
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Screen>> updatebyid(@RequestParam int id,@RequestBody Screen screen )
	{
		return Screenservice.update(id, screen);
		
	}

}
