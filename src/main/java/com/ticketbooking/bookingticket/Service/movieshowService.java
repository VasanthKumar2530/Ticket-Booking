package com.ticketbooking.bookingticket.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.ticketbooking.bookingticket.dao.movieshowDao;
import com.ticketbooking.bookingticket.entity.Movieshow;
import com.ticketbooking.bookingticket.exception.movieshowException;
import com.ticketbooking.bookingticket.util.ResponseStructure;

@Service
public class movieshowService {
	@Autowired
	movieshowDao  showDao;
	public  ResponseEntity<ResponseStructure<Movieshow>> save(Movieshow Show) {
		ResponseStructure<Movieshow> structure = new ResponseStructure<Movieshow>();
		structure.setData(showDao.save(Show));
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("show saved");
		return new ResponseEntity<ResponseStructure<Movieshow>>(structure, HttpStatus.CREATED);
}

public  ResponseEntity<ResponseStructure<List<Movieshow>>> findbyall() {
	List<Movieshow> dShow=showDao.findallShow();
	if(dShow!=null) {
		ResponseStructure<List<Movieshow>> structure = new ResponseStructure();
		structure.setData(dShow);
		structure.setMessage("Show  found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Movieshow>>>(structure, HttpStatus.FOUND);

	}
	 throw new movieshowException("movieshow NotFound  ");
}
	

public ResponseEntity<ResponseStructure<Movieshow>> findbyId(int ShowId)  {
	Movieshow c = showDao.findById(ShowId);
	if (c != null) {
		ResponseStructure<Movieshow> structure = new ResponseStructure<Movieshow>();
		structure.setData(showDao.findById(ShowId));
		structure.setMessage("Show found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<Movieshow>>(structure, HttpStatus.FOUND);

	}else {
		 throw new movieshowException("movieshow NotFound for given id");
	}

 
}
public ResponseEntity<ResponseStructure<Movieshow>> update(int ShowId, Movieshow show) {
	Movieshow dShow=showDao.update(ShowId,show);

		if (dShow!= null) {
			ResponseStructure<Movieshow> structure = new ResponseStructure<Movieshow>();
			structure.setData(dShow);
			structure.setMessage("show updated");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Movieshow>>(structure, HttpStatus.OK);
		}
		 throw new movieshowException("movieshow NotFound to update ");
	}

	public ResponseEntity<ResponseStructure<Movieshow>> deletebyid(int ShowId) {
		Movieshow dShow=showDao.delete(ShowId);
		
		if (dShow!= null) {
			ResponseStructure<Movieshow> structure = new ResponseStructure<Movieshow>();
			structure.setData(dShow);
			structure.setMessage("show deleted");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Movieshow>>(structure, HttpStatus.OK);
		}
		 throw new movieshowException("movieshow NotFound  to delete");
	}
}
