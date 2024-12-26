package com.ticketbooking.bookingticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ticketbooking.bookingticket.dao.TheatreDao ;
import com.ticketbooking.bookingticket.entity.Theatre;
import com.ticketbooking.bookingticket.exception.theatreException;
import com.ticketbooking.bookingticket.util.ResponseStructure;

@Service
public class TheatreService {
	@Autowired
	TheatreDao  theatreDao;
	public  ResponseEntity<ResponseStructure<Theatre>> save(Theatre Theatre) {
		ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
		structure.setData(theatreDao.save(Theatre));
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Theatre saved");
		return new ResponseEntity<ResponseStructure<Theatre>>(structure, HttpStatus.CREATED);
}

public  ResponseEntity<ResponseStructure<List<Theatre>>> findbyall() {
	List<Theatre> dTheatre=theatreDao.findallTheatre();
	if (dTheatre!= null) {
		ResponseStructure<List<Theatre>> structure = new ResponseStructure();
		structure.setData(dTheatre);
		structure.setMessage("Theatre  found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Theatre>>>(structure, HttpStatus.FOUND);
	}
	
	 throw new theatreException("theatre NotFound");
}
	

public ResponseEntity<ResponseStructure<Theatre>> findbyId(int TheatreId)  {
  Theatre c = theatreDao.findById(TheatreId);
	if (c != null) {
		ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
		structure.setData(theatreDao.findById(TheatreId));
		structure.setMessage("Theatre found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<Theatre>>(structure, HttpStatus.FOUND);

	}else {
		 throw new theatreException("theatre NotFound for given id");
	}

 
}

public ResponseEntity<ResponseStructure<Theatre>> update(int TheatreId, Theatre theatre) {
	Theatre dTheatre=theatreDao.update(TheatreId, theatre);
	
		if (dTheatre!= null) {
			ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
			structure.setData(dTheatre);
			structure.setMessage("Theatre updated");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Theatre>>(structure, HttpStatus.OK);
		}
		 throw new theatreException("theatre NotFound to update");
	}

	public ResponseEntity<ResponseStructure<Theatre>> deletebyid(int TheatreId) {
		Theatre dTheatre=theatreDao.delete(TheatreId);

		if (dTheatre!= null) {
			ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
			structure.setData(dTheatre);
			structure.setMessage("Theatre deleted");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Theatre>>(structure, HttpStatus.OK);
		}
		 throw new theatreException("theatre NotFound to delete");
	}
}
