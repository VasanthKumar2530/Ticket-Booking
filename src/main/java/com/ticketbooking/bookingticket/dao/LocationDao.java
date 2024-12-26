package com.ticketbooking.bookingticket.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticketbooking.bookingticket.entity.Location;
import com.ticketbooking.bookingticket.repository.LocationRepository;



@Repository
public class LocationDao {
	@Autowired
	LocationRepository locationRepository;
	public Location save(Location Location) {
		return locationRepository.save(Location);
		
	}
	public List<Location> findallLocation() {
		return locationRepository.findAll(); 
		
	}
  public Location findById(int id) {
	 Optional<Location> Location= locationRepository.findById(id);
	 if(Location.isPresent()) {
		 return Location.get();
	 }
	 return null;
  }
	
  public Location update(int id,Location Location) {
	   Location location=findById(id);
	   if(location!=null) {
		   Location.setLocationId(id);
		  return locationRepository.save(Location);
	   }
	   return null;
  }

  public Location delete(int id) {
	   Location Location=findById(id);
	   if(Location!=null) {
	  locationRepository.delete(Location);
	  return Location;
	   }
	   return null;
  }

	
	
	
	
	}
