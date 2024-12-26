package com.ticketbooking.bookingticket.dao;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticketbooking.bookingticket.entity.Booking;
import com.ticketbooking.bookingticket.repository.BookingRepository;
@Repository
public class BookingDao {
	@Autowired
	BookingRepository bookingRepository;
	public Booking save(Booking Booking) {
		return bookingRepository.save(Booking);
		
	}
	public List<Booking> findallBooking() {
		return bookingRepository.findAll(); 
		
	}
  public Booking findById(int id) {
	 Optional<Booking> Booking= bookingRepository.findById(id);
	 if(Booking.isPresent()) {
		 return Booking.get();
	 }
	 return null;
  }
   public Booking update(int id,Booking booking) {
	   Booking Booking=findById(id);
	   if(Booking!=null) {
		   booking.setBookingId(id);
		  return bookingRepository.save(booking);
	   }
	   return null;
   }

   public Booking delete(int id) {
	   Booking Booking=findById(id);
	   if(Booking!=null) {
	  bookingRepository.delete(Booking);
	  return Booking;
	   }
	   return null;
   }
  
}
