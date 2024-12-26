package com.ticketbooking.bookingticket.dao;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticketbooking.bookingticket.dto.Admindto;
import com.ticketbooking.bookingticket.dto.Userdto;
import com.ticketbooking.bookingticket.entity.Admin;
import com.ticketbooking.bookingticket.repository.OwnerRepository;

@Repository
public class OwnerDao {
	@Autowired
	ModelMapper m;
	@Autowired
	OwnerRepository ownerRepository;
	public Admin save(Admin Owner) {
		return ownerRepository.save(Owner);
		
	}
	public List<Admin> findallOwner() {
		
		return ownerRepository.findAll(); 
		
	}
  public Admindto findById(int id) {
	 Optional<Admin> Owner= ownerRepository.findById(id);
	 if(Owner.isPresent()) {
		 return m.map(Owner.get(), Admindto.class);
	 }
	 return null;
  }
  public Admindto update(int id,Admin Owner) {

	  Admindto  owner=findById(id);
	   if(owner!=null) {
		   Owner.setAdminId(id);
		   ownerRepository.save(Owner);
			  Admindto o=findById(id);

		  return o;
	   }
	   return null;
  }

  public Admindto delete(int id) {

	 Admindto  owner=findById(id);
	   if(owner!=null) {
			 Optional<Admin> Owner= ownerRepository.findById(id);

	  ownerRepository.delete(Owner.get());
	  return owner;
	   }
	   return null;
  }

}
