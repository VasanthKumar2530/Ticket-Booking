package com.ticketbooking.bookingticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.ticketbooking.bookingticket.dao.LocationDao ;
import com.ticketbooking.bookingticket.entity.Location;
import com.ticketbooking.bookingticket.exception.locationException;
import com.ticketbooking.bookingticket.util.ResponseStructure;

@Service
public class Locationservice {
	@Autowired
	LocationDao  locationDao;
	public  ResponseEntity<ResponseStructure<Location>> save(Location Location) {
		ResponseStructure<Location> structure = new ResponseStructure<Location>();
		structure.setData(locationDao.save(Location));
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Location saved");
		return new ResponseEntity<ResponseStructure<Location>>(structure, HttpStatus.CREATED);
}

public  ResponseEntity<ResponseStructure<List<Location>>> findbyall() {
	List<Location> dLocation=locationDao.findallLocation();
	if(dLocation !=null) {
		ResponseStructure<List<Location>> structure = new ResponseStructure();
		structure.setData(dLocation);
		structure.setMessage("Location  found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Location>>>(structure, HttpStatus.FOUND);
	}
	throw new locationException("location NotFound  ");

}
	

public ResponseEntity<ResponseStructure<Location>> findbyId(int LocationId)  {
  Location c = locationDao.findById(LocationId);
	if (c != null) {
		ResponseStructure<Location> structure = new ResponseStructure<Location>();
		structure.setData(locationDao.findById(LocationId));
		structure.setMessage("Location found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<Location>>(structure, HttpStatus.FOUND);

	}else {
		throw new locationException("location NotFound  for given id");
	}

 
}
public ResponseEntity<ResponseStructure<Location>> update(int LocationId, Location location) {
	Location dLocation =locationDao.update(LocationId, location);

		if (dLocation!= null) {
			ResponseStructure<Location> structure = new ResponseStructure<Location>();
			structure.setData(dLocation);
			structure.setMessage("location updated");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Location>>(structure, HttpStatus.OK);
		}
		throw new locationException("location NotFound to update ");
	}

	public ResponseEntity<ResponseStructure<Location>> deletebyid(int LocationId) {
		Location dLocation =locationDao.delete(LocationId);
		if (dLocation!= null) {
			ResponseStructure<Location> structure = new ResponseStructure<Location>();
			structure.setData(dLocation);
			structure.setMessage("location deleted");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Location>>(structure, HttpStatus.OK);
		}
		throw new locationException("location NotFound to delete ");
	}
}
