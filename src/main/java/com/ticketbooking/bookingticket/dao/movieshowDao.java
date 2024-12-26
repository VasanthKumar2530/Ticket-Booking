package com.ticketbooking.bookingticket.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticketbooking.bookingticket.entity.Movieshow;
import com.ticketbooking.bookingticket.repository.ShowRepository;

@Repository
public class movieshowDao {
	@Autowired
	ShowRepository showRepository;
	public Movieshow save(Movieshow Show) {
		return showRepository.save(Show);
		
	}
	public List<Movieshow> findallShow() {
		return showRepository.findAll(); 
		
	}
  public Movieshow findById(int id) {
	 Optional<Movieshow> Show= showRepository.findById(id);
	 if(Show.isPresent()) {
		 return Show.get();
	 }
	 return null;
  }
  public Movieshow update(int id,Movieshow Show) {
	  Movieshow show=findById(id);
	   if(show!=null) {
		   Show.setShowId(id);
		  return showRepository.save(Show);
	   }
	   return null;
  }

  public Movieshow delete(int id) {
	  Movieshow Show=findById(id);
	   if(Show!=null) {
	  showRepository.delete(Show);
	  return Show;
	   }
	   return null;
  }

}
