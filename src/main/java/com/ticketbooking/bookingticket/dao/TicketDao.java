package com.ticketbooking.bookingticket.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticketbooking.bookingticket.entity.Ticket;
import com.ticketbooking.bookingticket.repository.TicketRepository;

@Repository
public class TicketDao {
	@Autowired
	TicketRepository ticketRepository;
	public Ticket save(Ticket Ticket) {
		return ticketRepository.save(Ticket);
		
	}
	public List<Ticket> findallTicket() {
		return ticketRepository.findAll(); 
		
	}
  public Ticket findById(int id) {
	 Optional<Ticket> Ticket= ticketRepository.findById(id);
	 if(Ticket.isPresent()) {
		 return Ticket.get();
	 }
	 return null;
  }
  public Ticket update(int id,Ticket Ticket) {
	   Ticket ticket=findById(id);
	   if(ticket!=null) {
		   Ticket.setTicketId(id);
		  return ticketRepository.save(Ticket);
	   }
	   return null;
  }

  public Ticket delete(int id) {
	   Ticket Ticket=findById(id);
	   if(Ticket!=null) {
	  ticketRepository.delete(Ticket);
	  return Ticket;
	   }
	   return null;
  }

}
