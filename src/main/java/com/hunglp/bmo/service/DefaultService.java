package com.hunglp.bmo.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface DefaultService<T, String extends Serializable> {

	List<T> getAll();

	T save(T entity);

	Optional<T> findById(String id);
	
	void deleteById(String id);
	
	

}
