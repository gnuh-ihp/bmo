package com.hunglp.bmo.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hunglp.bmo.dao.DefaultRepository;

public abstract class AbstractService<T, Long extends Serializable> implements Service<T, Long> {
	@Autowired
	DefaultRepository<T, Long> defaultRepository;

	public AbstractService(DefaultRepository<T, Long> defaultRepository) {
		this.defaultRepository = defaultRepository;
	}

	@Override
	public List<T> getAll() {
		return defaultRepository.findAll();
	}

}
