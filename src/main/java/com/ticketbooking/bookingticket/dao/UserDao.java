package com.ticketbooking.bookingticket.dao;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticketbooking.bookingticket.dto.Userdto;
import com.ticketbooking.bookingticket.entity.User;



@Repository
public class UserDao {
	@Autowired
ModelMapper m;
	
	@Autowired
	com.ticketbooking.bookingticket.repository.UserRepository userRepository;
	public User save(User user) {
		return userRepository.save(user);
		
	}
	public List<User> findalluser() {
		return userRepository.findAll(); 
		
	}
  public Userdto findById(int id) {
	 Optional<User> user= userRepository.findById(id);
	 if(user.isPresent()) {
		 return m.map(user.get(), Userdto.class);
	 }
	 return null;
  }
  public Userdto update(int id,User User) {
	   Userdto user=findById(id);
	   if(user!=null) {
		   User.setUserId(id);
		    userRepository.save(User);
		   Userdto u=findById(id);

		   return u;
	   }
	   return null;
  }

  public Userdto delete(int id) {
	   Userdto User=findById(id);
	   if(User!=null) {
		   Optional<User> u=userRepository.findById(id);
	  userRepository.delete(u.get());
	  return User;
	   }
	   return null;
  }
  public User findByemail(String email) {
	return userRepository.findByuserEmail(email);
	 
}
 
}
