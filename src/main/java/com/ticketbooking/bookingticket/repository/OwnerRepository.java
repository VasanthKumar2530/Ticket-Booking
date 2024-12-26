package com.ticketbooking.bookingticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.bookingticket.entity.Admin;


public interface OwnerRepository extends JpaRepository<Admin,Integer> {

}
