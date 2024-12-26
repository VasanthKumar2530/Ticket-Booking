package com.ticketbooking.bookingticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ticketbooking.bookingticket.dao.SeatDao;
import com.ticketbooking.bookingticket.entity.Seat;
import com.ticketbooking.bookingticket.exception.seatException;
import com.ticketbooking.bookingticket.util.ResponseStructure;


@Service
public class SeatService {
	@Autowired
	SeatDao  seatDao;
	public  ResponseEntity<ResponseStructure<Seat>> save(Seat Seat) {
		ResponseStructure<Seat> structure = new ResponseStructure<Seat>();
		structure.setData(seatDao.save(Seat));
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("seat saved");
		return new ResponseEntity<ResponseStructure<Seat>>(structure, HttpStatus.CREATED);
}

public  ResponseEntity<ResponseStructure<List<Seat>>> findbyall() {
	
	List<Seat> dSeat=seatDao.findallSeat();
	if(dSeat!=null) {
		ResponseStructure<List<Seat>> structure = new ResponseStructure();
		structure.setData(dSeat);
		structure.setMessage("Seat  found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Seat>>>(structure, HttpStatus.FOUND);
	}
	
	 throw new seatException("seat NotFound");
}
	

public ResponseEntity<ResponseStructure<Seat>> findbyId(int SeatId)  {
  Seat c = seatDao.findById(SeatId);
	if (c != null) {
		ResponseStructure<Seat> structure = new ResponseStructure<Seat>();
		structure.setData(seatDao.findById(SeatId));
		structure.setMessage("Seat found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<Seat>>(structure, HttpStatus.FOUND);

	}else {
		 throw new seatException("seat NotFound foer given id");
	}

 
}
public ResponseEntity<ResponseStructure<Seat>> update(int SeatId, Seat seat) {
	Seat dSeat=seatDao.update(SeatId, seat);

		if (dSeat!= null) {
			ResponseStructure<Seat> structure = new ResponseStructure<Seat>();
			structure.setData(dSeat);
			structure.setMessage("seat updated");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Seat>>(structure, HttpStatus.OK);
		}
		 throw new seatException("seat NotFound to update");
	}

	public ResponseEntity<ResponseStructure<Seat>> deletebyid(int SeatId) {
		Seat dSeat=seatDao.delete(SeatId);
		
		if (dSeat != null) {
			ResponseStructure<Seat> structure = new ResponseStructure<Seat>();
			structure.setData(dSeat);
			structure.setMessage("seat deleted");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Seat>>(structure, HttpStatus.OK);
		}
		 throw new seatException("seat NotFound to delete");
	}
}
