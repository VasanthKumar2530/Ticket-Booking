package com.ticketbooking.bookingticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.bookingticket.entity.Theatre;


public interface TheatreRepository extends JpaRepository<Theatre,Integer>  {
	

}
