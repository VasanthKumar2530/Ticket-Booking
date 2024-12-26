package com.ticketbooking.bookingticket.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.bookingticket.entity.Movieshow;


public interface ShowRepository extends JpaRepository<Movieshow,Integer>{

}
