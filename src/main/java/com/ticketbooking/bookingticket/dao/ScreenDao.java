package com.ticketbooking.bookingticket.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticketbooking.bookingticket.dto.screendto;
import com.ticketbooking.bookingticket.entity.Screen;
import com.ticketbooking.bookingticket.repository.ScreenRepository;

@Repository
public class ScreenDao {
	@Autowired
	ScreenRepository screenRepository;
	public Screen save(screendto screen) {
		Screen Screen =new Screen();
		Screen.setScreenName(screen.getScreenName());
		
      int seat=screen.getNoOfSeats();
		int s=seat/3;

		Map<String,Boolean> map=new LinkedHashMap();
	      int d=seat%3;
		char c='A';
		 int no=2;
		 int k=1;
		 
		 for( int i=1;i<=seat-d;i++) {
			 if(i<=s) {
                  map.put(i+String.valueOf(c),false);
				 k=i;
			 }
			 else {
				s*=no;
				i--;
				c++;
                if(no<=3) {
					no++;
	               }
				}
			 }
		 c++;
		 for(int j=k+1;j<=seat;j++) {
             map.put(j+String.valueOf(c),false);
		 }
		
		Screen.setMap(map);
		
		return screenRepository.save(Screen);
		
	}
	public List<Screen> findallScreen() {
		return screenRepository.findAll(); 
		
	}
  public Screen findById(int id) {
	 Optional<Screen> Screen= screenRepository.findById(id);
	 if(Screen.isPresent()) {
		 return Screen.get();
	 }
	 return null;
  }
  public Screen update(int id,Screen Screen) {
	   Screen screen=findById(id);
	   if(screen!=null) {
		   Screen.setSreenId(id);
		  return screenRepository.save(Screen);
	   }
	   return null;
  }

  public Screen delete(int id) {
	   Screen Screen=findById(id);
	   if(Screen!=null) {
	  screenRepository.delete(Screen);
	  return Screen;
	   }
	   return null;
  }

}
