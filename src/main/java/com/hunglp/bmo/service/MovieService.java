package com.hunglp.bmo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunglp.bmo.entity.Movie;
import com.hunglp.bmo.repository.MovieRepository;

@Service
public class MovieService extends AbstractService<Movie, String> {

	@Autowired
	public MovieService(MovieRepository movieRepository) {
		super(movieRepository);
		// TODO Auto-generated constructor stub
	}

}
