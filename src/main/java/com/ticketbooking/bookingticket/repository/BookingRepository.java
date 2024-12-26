package com.ticketbooking.bookingticket.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.bookingticket.entity.Booking;


public interface BookingRepository extends JpaRepository<Booking,Integer>{
        
}
