package com.ticketbooking.bookingticket.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.bookingticket.entity.Ticket;


public interface TicketRepository extends JpaRepository<Ticket,Integer>{

}
