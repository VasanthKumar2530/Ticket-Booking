package com.ticketbooking.bookingticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.ticketbooking.bookingticket.dao.ScreenDao;
import com.ticketbooking.bookingticket.dto.screendto;
import com.ticketbooking.bookingticket.entity.Screen;
import com.ticketbooking.bookingticket.exception.screenException;
import com.ticketbooking.bookingticket.util.ResponseStructure;

@Service
public class ScreenService {
	@Autowired
	ScreenDao  screenDao;
	public  ResponseEntity<ResponseStructure<Screen>> save(screendto Screen) {
		ResponseStructure<Screen> structure = new ResponseStructure<Screen>();
		structure.setData(screenDao.save(Screen));
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("screen saved");
		return new ResponseEntity<ResponseStructure<Screen>>(structure, HttpStatus.CREATED);
}

public  ResponseEntity<ResponseStructure<List<Screen>>> findbyall() {
	List<Screen> dScreen=screenDao.findallScreen();
	if(dScreen!=null) {
		ResponseStructure<List<Screen>> structure = new ResponseStructure();
		structure.setData(dScreen);
		structure.setMessage("Screen  found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Screen>>>(structure, HttpStatus.FOUND);
	}
	
	 throw new screenException("screen NotFound ");
}
	

public ResponseEntity<ResponseStructure<Screen>> findbyId(int ScreenId)  {
  Screen c = screenDao.findById(ScreenId);
	if (c != null) {
		ResponseStructure<Screen> structure = new ResponseStructure<Screen>();
		structure.setData(screenDao.findById(ScreenId));
		structure.setMessage("Screen found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<Screen>>(structure, HttpStatus.FOUND);

	}else {
		 throw new screenException("screen NotFound gor given id");

	}

 
}
public ResponseEntity<ResponseStructure<Screen>> update(int ScreenId, Screen Screen) {
	Screen dScreen = screenDao.update(ScreenId, Screen);
		if (dScreen!= null) {
			ResponseStructure<Screen> structure = new ResponseStructure<Screen>();
			structure.setData(dScreen);
			structure.setMessage("car updated");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Screen>>(structure, HttpStatus.OK);
		}
		 throw new screenException("screen NotFound to upadate ");
	}

	public ResponseEntity<ResponseStructure<Screen>> deletebyid(int ScreenId) {
		Screen dScreen = screenDao.delete(ScreenId);

		if (dScreen!= null) {
			ResponseStructure<Screen> structure = new ResponseStructure<Screen>();
			structure.setData(dScreen);
			structure.setMessage("car deleted");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Screen>>(structure, HttpStatus.OK);
		}
		 throw new screenException("screen NotFound  to delete");
	}
}
