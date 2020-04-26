package com.hunglp.bmo.service;

import org.springframework.stereotype.Service;

import com.hunglp.bmo.dao.DefaultRepository;
import com.hunglp.bmo.entity.City;

@Service
public class CityService extends AbstractService<City, Long> {

	public CityService(DefaultRepository<City, Long> repository) {
		super(repository);
	}

}
