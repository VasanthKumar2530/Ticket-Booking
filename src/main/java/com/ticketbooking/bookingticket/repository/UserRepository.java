package com.ticketbooking.bookingticket.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.bookingticket.entity.User;


public interface UserRepository extends JpaRepository<User,Integer>{
	public User findByuserEmail(String userEmail);

}
