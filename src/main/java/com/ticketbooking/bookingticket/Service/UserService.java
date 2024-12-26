package com.ticketbooking.bookingticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ticketbooking.bookingticket.dto.Userdto;
import com.ticketbooking.bookingticket.entity.User;
import com.ticketbooking.bookingticket.exception.userException;
import com.ticketbooking.bookingticket.util.ResponseStructure;
@Service
public class UserService {
	@Autowired
	com.ticketbooking.bookingticket.dao.UserDao  userDao;
	
	public  ResponseEntity<ResponseStructure<User>> save(User User) {
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setData(userDao.save(User));
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("user saved");
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
}

public  ResponseEntity<ResponseStructure<List<User>>> findbyall() {
	List<User> dUser=userDao.findalluser();
	if(dUser!=null) {
		ResponseStructure<List<User>> structure = new ResponseStructure<List<User>>();
		structure.setData(dUser);
		structure.setMessage("User  found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.FOUND);

	}
	 throw new userException("No data present");

}
	

public ResponseEntity<ResponseStructure<Userdto>> findbyId(int UserId)  {
  Userdto c = userDao.findById(UserId);
	if (c != null) {
		ResponseStructure<Userdto> structure = new ResponseStructure<Userdto>();
		structure.setData(c);
		structure.setMessage("User found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<Userdto>>(structure, HttpStatus.FOUND);

	}else {
		 throw new userException("user NotFound");

	}

 
}
public ResponseEntity<ResponseStructure<Userdto>> update(int UserId, User user) {
    Userdto dUser =userDao.update(UserId, user);
		if (dUser != null) {
			ResponseStructure<Userdto> structure = new ResponseStructure<Userdto>();
			structure.setData(dUser);
			structure.setMessage("User updated");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Userdto>>(structure, HttpStatus.OK);
		}
		 throw new userException("user NotFound to update");
	}

	public ResponseEntity<ResponseStructure<Userdto>> deletebyid(int UserId) {
	         Userdto dUser =userDao.delete(UserId);
		if (dUser!= null) {
			ResponseStructure<Userdto> structure = new ResponseStructure<Userdto>();
			structure.setData(dUser);
			structure.setMessage("User deleted");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Userdto>>(structure, HttpStatus.OK);
		}
		 throw new userException("user NotFound to delete");
	}

public  ResponseEntity<ResponseStructure<Userdto>> findbyemail(String email) {
	User dUser=userDao.findByemail(email);
	if(dUser!=null) {
		ResponseStructure<Userdto> structure = new ResponseStructure();
		  Userdto c = userDao.findById(dUser.getUserId());

		structure.setData(c);
		
		structure.setMessage("email  found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<Userdto>>(structure, HttpStatus.FOUND);

	}
	 throw new userException("email not present");

}
public  ResponseEntity<ResponseStructure<Userdto>> verifylogin(String email,String password) {
	User dUser=userDao.findByemail(email);
	
	if(dUser!=null) {
		if(password.equals(dUser.getUserPassword())) {
			  Userdto c = userDao.findById(dUser.getUserId());
			ResponseStructure<Userdto> structure = new ResponseStructure();
			structure.setData(c);
			structure.setMessage("login suceess");
			structure.setStatus(HttpStatus.FOUND.value());

			return new ResponseEntity<ResponseStructure<Userdto>>(structure, HttpStatus.FOUND);
		}
		 throw new userException("password mismatch");


	}
	 throw new userException("email not present");

}

}
