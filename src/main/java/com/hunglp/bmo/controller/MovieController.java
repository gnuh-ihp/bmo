package com.hunglp.bmo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hunglp.bmo.entity.Movie;
import com.hunglp.bmo.error_handle.MyResourceNotFoundException;
import com.hunglp.bmo.service.MovieService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/bmo/api/v1/movies")
	public List<Movie> getAllMovies() {
		List<Movie> movies = movieService.getAll();
		return movies;
	}

	@PostMapping("/bmo/api/v1/movies")
	public Movie createMovie(@Valid @RequestBody Movie movie) {
		return movieService.save(movie);
	}

	@GetMapping("/bmo/api/v1/movies/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable(value = "id") String movieId)
			throws MyResourceNotFoundException {
		Optional<Movie> movie = movieService.findById(movieId);
		movie.orElseThrow(() -> new MyResourceNotFoundException("Movie not found for this id : " + movieId));

		return ResponseEntity.ok().body(movie.get());
	}

	@PutMapping("/bmo/api/v1/movies/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") String movieId,
			@Valid @RequestBody Movie movieDetails) throws MyResourceNotFoundException {
		Optional<Movie> movieOpt = movieService.findById(movieId);
		movieOpt.orElseThrow(() -> new MyResourceNotFoundException("Movie not found for this id : " + movieId));

		Movie movie = movieOpt.get();
		movie.setName(movieDetails.getName());
		movie.setDescription(movieDetails.getDescription());
		movie.setDirectors(movieDetails.getDirectors());
		movie.setRunningTime(movieDetails.getRunningTime());
		movie.setProducer(movieDetails.getProducer());

		final Movie updatedMovie = movieService.save(movie);
		return ResponseEntity.ok(updatedMovie);
	}

	@DeleteMapping("/bmo/api/v1/movies/{id}")
	public Map<String, Boolean> deleteMovie(@PathVariable(value = "id") String movieId)
			throws MyResourceNotFoundException {
		Optional<Movie> movieOpt = movieService.findById(movieId);
		movieOpt.orElseThrow(() -> new MyResourceNotFoundException("Movie not found for this id : " + movieId));

		movieService.deleteById(movieId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
