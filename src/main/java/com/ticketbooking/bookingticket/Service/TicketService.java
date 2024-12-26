package com.ticketbooking.bookingticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ticketbooking.bookingticket.dao.TicketDao;
import com.ticketbooking.bookingticket.entity.Ticket;
import com.ticketbooking.bookingticket.exception.ticketException;
import com.ticketbooking.bookingticket.util.ResponseStructure;

@Service
public class TicketService {
	@Autowired
	TicketDao  ticketDao;
	
	public  ResponseEntity<ResponseStructure<Ticket>> save(Ticket Ticket) {
		ResponseStructure<Ticket> structure = new ResponseStructure<Ticket>();
		structure.setData(ticketDao.save(Ticket));
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Ticket saved");
		return new ResponseEntity<ResponseStructure<Ticket>>(structure, HttpStatus.CREATED);
}

public  ResponseEntity<ResponseStructure<List<Ticket>>> findbyall() {
	List<Ticket> dTicket=ticketDao.findallTicket();
	if(dTicket!=null) {
		ResponseStructure<List<Ticket>> structure = new ResponseStructure();
		structure.setData(dTicket);
		structure.setMessage("Ticket  found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Ticket>>>(structure, HttpStatus.FOUND);
	}
	 throw new ticketException("ticket NotFound");

}
	

public ResponseEntity<ResponseStructure<Ticket>> findbyId(int TicketId)  {
  Ticket c = ticketDao.findById(TicketId);
	if (c != null) {
		ResponseStructure<Ticket> structure = new ResponseStructure<Ticket>();
		structure.setData(ticketDao.findById(TicketId));
		structure.setMessage("Ticket found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<Ticket>>(structure, HttpStatus.FOUND);

	}else {
		 throw new ticketException("ticket Not Found gor given id");
	}

 
}
public ResponseEntity<ResponseStructure<Ticket>> update(int TicketId, Ticket ticket) {
		Ticket dTicket=ticketDao.update(TicketId,ticket);
		if (dTicket!= null) {
			ResponseStructure<Ticket> structure = new ResponseStructure<Ticket>();
			structure.setData(dTicket);
			structure.setMessage("Ticket updated");
			structure.setStatus(HttpStatus.OK.value());
            return new ResponseEntity<ResponseStructure<Ticket>>(structure, HttpStatus.OK);
		}
		 throw new ticketException("ticket NotFound to update");
	}

	public ResponseEntity<ResponseStructure<Ticket>> deletebyid(int TicketId) {
		Ticket dTicket=ticketDao.delete(TicketId);

		if (dTicket != null) {
			ResponseStructure<Ticket> structure = new ResponseStructure<Ticket>();
			structure.setData(dTicket);
			structure.setMessage("Ticket deleted");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Ticket>>(structure, HttpStatus.OK);
		}
		 throw new ticketException("ticket NotFound to delete");
	}
}
