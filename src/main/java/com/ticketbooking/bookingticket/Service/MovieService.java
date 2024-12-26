package com.ticketbooking.bookingticket.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ticketbooking.bookingticket.dao.MovieDao;
import com.ticketbooking.bookingticket.entity.Movie;
import com.ticketbooking.bookingticket.exception.movieException;
import com.ticketbooking.bookingticket.util.ResponseStructure;
@Service
public class MovieService {
	@Autowired
      MovieDao movieDao;
	public  ResponseEntity<ResponseStructure<Movie>> save(Movie Movie) {
		ResponseStructure<Movie> structure = new ResponseStructure<Movie>();
		structure.setData(movieDao.save(Movie));
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Movie saved");
		return new ResponseEntity<ResponseStructure<Movie>>(structure, HttpStatus.CREATED);
}

public  ResponseEntity<ResponseStructure<List<Movie>>> findbyall() {
	List<Movie> dMovie=movieDao.findallMovie();
	if(dMovie!=null) {
		ResponseStructure<List<Movie>> structure = new ResponseStructure();
		structure.setData(dMovie);
		structure.setMessage("Movie  found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Movie>>>(structure, HttpStatus.FOUND);


	}
	throw new movieException("movie NotFound  ");
	}
	

public ResponseEntity<ResponseStructure<Movie>> findbyId(int MovieId)  {
  Movie c = movieDao.findById(MovieId);
	if (c != null) {
		ResponseStructure<Movie> structure = new ResponseStructure<Movie>();
		structure.setData(movieDao.findById(MovieId));
		structure.setMessage("Movie found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<Movie>>(structure, HttpStatus.FOUND);

	}else {
		throw new movieException("movie NotFound  for given id ");
	}

 
}
public ResponseEntity<ResponseStructure<Movie>> update(int MovieId, Movie movie) {
	Movie dMovie=movieDao.update(MovieId,movie);
	
		if (dMovie!= null) {
			ResponseStructure<Movie> structure = new ResponseStructure<Movie>();
			structure.setData(dMovie);
			structure.setMessage("Movie  updated");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Movie>>(structure, HttpStatus.OK);
		}
		throw new movieException("movie NotFound  to update ");
	}

	public ResponseEntity<ResponseStructure<Movie>> deletebyid(int MovieId) {
		Movie dMovie=movieDao.delete(MovieId);

		if (dMovie!= null) {
			ResponseStructure<Movie> structure = new ResponseStructure<Movie>();
			structure.setData(dMovie);
			structure.setMessage("movie deleted");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Movie>>(structure, HttpStatus.OK);
		}
		throw new movieException("movie NotFound  to delete ");
	}
	public ResponseEntity<ResponseStructure<List<Movie>>> findbyname(String name) {
		List<Movie> dMovie=movieDao.findbyname(name);
if(dMovie!=null) {
	ResponseStructure<List<Movie>> structure = new ResponseStructure();
	structure.setData(dMovie);
	structure.setMessage("movie found by name");
	structure.setStatus(HttpStatus.FOUND.value());

	return new ResponseEntity<ResponseStructure<List<Movie>>>(structure, HttpStatus.FOUND);
}
throw new movieException("movie NotFound  for given name ");
	}

}
