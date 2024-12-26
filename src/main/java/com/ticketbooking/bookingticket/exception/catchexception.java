package com.ticketbooking.bookingticket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ticketbooking.bookingticket.util.ResponseStructure;
@RestControllerAdvice
public class catchexception {
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> usernotfound(userException exeception){
		ResponseStructure<String> structure =new ResponseStructure<String>();
		structure.setData(exeception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("user not found ");
		return  new  ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> usernotfound(ticketException exeception){
		ResponseStructure<String> structure =new ResponseStructure<String>();
		structure.setData(exeception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("ticket not found");
		return  new  ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> usernotfound(theatreException exeception){
		ResponseStructure<String> structure =new ResponseStructure<String>();
		structure.setData(exeception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("theatre not found ");
		return  new  ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> usernotfound(seatException exeception){
		ResponseStructure<String> structure =new ResponseStructure<String>();
		structure.setData(exeception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("seat not found ");
		return  new  ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> usernotfound(screenException exeception){
		ResponseStructure<String> structure =new ResponseStructure<String>();
		structure.setData(exeception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("screen not found ");
		return  new  ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> usernotfound(movieshowException exeception){
		ResponseStructure<String> structure =new ResponseStructure<String>();
		structure.setData(exeception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("movieshow not found");
		return  new  ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> usernotfound(ownerException exeception){
		ResponseStructure<String> structure =new ResponseStructure<String>();
		structure.setData(exeception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Admin not found ");
		return  new  ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> usernotfound(movieException exeception){
		ResponseStructure<String> structure =new ResponseStructure<String>();
		structure.setData(exeception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("movie not found ");
		return  new  ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> usernotfound(locationException exeception){
		ResponseStructure<String> structure =new ResponseStructure<String>();
		structure.setData(exeception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("location not found ");
		return  new  ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> usernotfound(bookingexception exeception){
		ResponseStructure<String> structure =new ResponseStructure<String>();
		structure.setData(exeception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Booking not found ");
		return  new  ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
		
	}

}
