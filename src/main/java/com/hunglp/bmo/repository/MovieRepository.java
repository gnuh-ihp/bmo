package com.hunglp.bmo.repository;

import org.springframework.stereotype.Repository;

import com.hunglp.bmo.entity.Movie;

@Repository
public interface MovieRepository extends DefaultRepository<Movie, String> {

}
