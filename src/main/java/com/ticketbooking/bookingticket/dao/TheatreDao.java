package com.ticketbooking.bookingticket.dao;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticketbooking.bookingticket.entity.Theatre;
import com.ticketbooking.bookingticket.repository.TheatreRepository;

@Repository
public class TheatreDao {
	@Autowired
	ModelMapper m;
	@Autowired
	TheatreRepository theatreRepository;
	public Theatre save(Theatre Theatre) {
		return theatreRepository.save(Theatre);
		
	}
	public List<Theatre> findallTheatre() {
		return theatreRepository.findAll(); 
		
	}
  public Theatre findById(int id) {
	 Optional<Theatre> Theatre= theatreRepository.findById(id);
	 if(Theatre.isPresent()) {
		 return Theatre.get();
	 }
	 return null;
  }
  

  public Theatre update(int id,Theatre Theatre) {
	   Theatre theatre=findById(id);
	   if(theatre!=null) {
		   Theatre.setTheatreId(id);
		  return theatreRepository.save(Theatre);
	   }
	   return null;
  }

  public Theatre delete(int id) {
	   Theatre Theatre=findById(id);
	   if(Theatre!=null) {
	  theatreRepository.delete(Theatre);
	  return Theatre;
	   }
	   return null;
  }

}
