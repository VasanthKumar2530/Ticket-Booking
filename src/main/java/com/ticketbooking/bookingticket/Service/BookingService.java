package com.ticketbooking.bookingticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ticketbooking.bookingticket.dao.BookingDao;
import com.ticketbooking.bookingticket.entity.Booking;
import com.ticketbooking.bookingticket.exception.bookingexception;
import com.ticketbooking.bookingticket.util.ResponseStructure;
@Service
public class BookingService {
 @Autowired
	BookingDao  Bookingdao;
	public  ResponseEntity<ResponseStructure<Booking>> save(Booking Booking) {
			ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
			structure.setData(Bookingdao.save(Booking));
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setMessage("Booking saved");
			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.CREATED);
	}
	
	public  ResponseEntity<ResponseStructure<List<Booking>>> findbyall() {
		List<Booking> dBooking=Bookingdao.findallBooking();
		if(dBooking!=null) {
			ResponseStructure<List<Booking>> structure = new ResponseStructure();
			structure.setData(dBooking);
			structure.setMessage("booking all data found found");
			structure.setStatus(HttpStatus.FOUND.value());

			return new ResponseEntity<ResponseStructure<List<Booking>>>(structure, HttpStatus.FOUND);

		}
		throw new bookingexception("booking NotFound  ");
	}
		
	
  public ResponseEntity<ResponseStructure<Booking>> findbyId(int BookingId)  {
	  Booking c = Bookingdao.findById(BookingId);
		if (c != null) {
			ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
			structure.setData(Bookingdao.findById(BookingId));
			structure.setMessage("Booking found");
			structure.setStatus(HttpStatus.FOUND.value());

			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.FOUND);

		}else {
			throw new bookingexception("booking NotFound for given id ");
		}

	 
  }
  public ResponseEntity<ResponseStructure<Booking>> update(int bookingId, Booking booking) {
	  Booking dbooking=Bookingdao.update(bookingId,booking);
		if (dbooking!= null) {
			ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
			structure.setData(dbooking);
			structure.setMessage("Bookig updated");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.OK);
		}
		throw new bookingexception("booking NotFound  to update");
	}

	public ResponseEntity<ResponseStructure<Booking>> deletebyid(int bookingId) {
		  Booking dbooking=Bookingdao.delete(bookingId);

		if (dbooking!= null) {
			ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
			structure.setData(dbooking);
			structure.setMessage("Booking deleted");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.OK);
		}
		throw new bookingexception("booking NotFound to delete ");
	}
}
