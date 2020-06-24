package com.hunglp.bmo.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.hunglp.bmo.repository.DefaultRepository;

public abstract class AbstractService<T, String extends Serializable> implements DefaultService<T, String> {
	protected DefaultRepository<T, String> defaultRepository;

	public AbstractService(DefaultRepository<T, String> defaultRepository) {
		this.defaultRepository = defaultRepository;
	}

	@Override
	public List<T> getAll() {
		return this.defaultRepository.findAll();
	}

	@Override
	public T save(T entity) {
		return defaultRepository.save(entity);
	}

	@Override
	public Optional<T> findById(String id) {
		return this.defaultRepository.findById(id);
	}

	@Override
	public void deleteById(String id) {
		this.defaultRepository.deleteById(id);
	}

}
