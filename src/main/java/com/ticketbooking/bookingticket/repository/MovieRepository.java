package com.ticketbooking.bookingticket.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.bookingticket.entity.Movie;


public interface MovieRepository extends JpaRepository<Movie,Integer>{
public  List<Movie> findBymovieName(String moviename);
            
}
