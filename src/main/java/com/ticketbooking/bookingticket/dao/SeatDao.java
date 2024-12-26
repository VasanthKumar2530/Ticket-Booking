package com.ticketbooking.bookingticket.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticketbooking.bookingticket.entity.Seat;
import com.ticketbooking.bookingticket.repository.SeatRepository;

@Repository
public class SeatDao {
	@Autowired
	SeatRepository seatRepository;
	public Seat save(Seat Seat) {
		return seatRepository.save(Seat);
		
	}
	public List<Seat> findallSeat() {
		return seatRepository.findAll(); 
		
	}
  public Seat findById(int id) {
	 Optional<Seat> Seat= seatRepository.findById(id);
	 if(Seat.isPresent()) {
		 return Seat.get();
	 }
	 return null;
  }
  public Seat update(int id,Seat Seat) {
	   Seat seat=findById(id);
	   if(seat!=null) {
		   Seat.setSeatId(id);
		  return seatRepository.save(Seat);
	   }
	   return null;
  }

  public Seat delete(int id) {
	   Seat Seat=findById(id);
	   if(Seat!=null) {
	  seatRepository.delete(Seat);
	  return Seat;
	   }
	   return null;
  }

}
