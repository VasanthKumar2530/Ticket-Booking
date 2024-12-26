package com.ticketbooking.bookingticket.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.bookingticket.entity.Location;


public interface LocationRepository extends JpaRepository<Location,Integer>{

}
