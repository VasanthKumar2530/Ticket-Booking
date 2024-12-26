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

import com.ticketbooking.bookingticket.Service.UserService;
import com.ticketbooking.bookingticket.dto.Userdto;
import com.ticketbooking.bookingticket.entity.User;
import com.ticketbooking.bookingticket.util.ResponseStructure;

@RestController
@RequestMapping("user")
public class UserRestController {
	@Autowired
	UserService Userservice;
	@PostMapping
    public ResponseEntity<ResponseStructure<User>> save(@RequestBody User User) {
    	return Userservice.save(User);
    }
	@GetMapping
    public ResponseEntity<ResponseStructure<Userdto>> findbyid(@RequestParam int id) {
    	return Userservice.findbyId(id); 
    }
	@GetMapping("all")
      public ResponseEntity<ResponseStructure<List<User>>> findAll() {    
    	return Userservice.findbyall();
    }
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Userdto>> deletebyid(int id)
	{
		
		return Userservice.deletebyid(id);
		
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Userdto>> updatebyid(@RequestParam int id,@RequestBody User user )
	{
		return Userservice.update(id, user);
		
	}
	@GetMapping("email")
    public ResponseEntity<ResponseStructure<Userdto>> findemail(String userEmail) {    
  	return Userservice.findbyemail(userEmail);
  }
	@GetMapping("login")
    public ResponseEntity<ResponseStructure<Userdto>> verifylogin(@RequestParam String userEmail,@RequestParam String userPassword) {    
  	return Userservice.verifylogin(userEmail, userPassword);
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
}
