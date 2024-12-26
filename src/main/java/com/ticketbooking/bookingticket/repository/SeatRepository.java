package com.ticketbooking.bookingticket.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.bookingticket.entity.Seat;


public interface SeatRepository extends JpaRepository<Seat,Integer>{

}
