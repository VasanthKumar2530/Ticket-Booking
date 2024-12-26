package com.ticketbooking.bookingticket.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ticketbooking.bookingticket.dao.OwnerDao;
import com.ticketbooking.bookingticket.dto.Admindto;
import com.ticketbooking.bookingticket.entity.Admin;
import com.ticketbooking.bookingticket.exception.ownerException;
import com.ticketbooking.bookingticket.util.ResponseStructure;

 

@Service
public class OwnerService {
	@Autowired
	ModelMapper m;
	@Autowired
	OwnerDao  ownerDao;
	public  ResponseEntity<ResponseStructure<Admin>> save(Admin Owner) {
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setData(ownerDao.save(Owner));
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Admin saved");
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
}

public  ResponseEntity<ResponseStructure<List<Admin>>> findbyall() {
	List<Admin> dOwner=ownerDao.findallOwner();
	if(dOwner!=null) {
		ResponseStructure<List<Admin>> structure = new ResponseStructure();
		structure.setData(dOwner);
		structure.setMessage("Admin  found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Admin>>>(structure, HttpStatus.FOUND);
	}
	 throw new ownerException("Admin NotFound ");

}
	

public ResponseEntity<ResponseStructure<Admindto>> findbyId(int OwnerId)  {
	Admindto c = ownerDao.findById(OwnerId);
	if (c != null) {
		ResponseStructure<Admindto> structure = new ResponseStructure<Admindto>();
		structure.setData(c);
		structure.setMessage("Admin found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<Admindto>>(structure, HttpStatus.FOUND);

	}else {
		 throw new ownerException("Admin NotFound gor given id ");
	}

 
}
public ResponseEntity<ResponseStructure<Admindto>> update(int OwnerId, Admin owner) {
	Admindto dOwner=ownerDao.update(OwnerId, owner);
		if (dOwner!= null) {
			ResponseStructure<Admindto> structure = new ResponseStructure<Admindto>();
			structure.setData(dOwner);
			structure.setMessage("Admin updated");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Admindto>>(structure, HttpStatus.OK);
		}
		 throw new ownerException("Admin NotFound  to update");
	}

	public ResponseEntity<ResponseStructure<Admindto>> deletebyid(int OwnerId) {
		Admindto dOwner=ownerDao.delete(OwnerId);
		if (dOwner!= null) {
			ResponseStructure<Admindto> structure = new ResponseStructure<Admindto>();
			structure.setData(dOwner);
			structure.setMessage("Admin deleted");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Admindto>>(structure, HttpStatus.OK);
		}
		 throw new ownerException("Admin NotFound to delete ");
	}
}
