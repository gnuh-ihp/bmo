package com.hunglp.bmo.dao;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DefaultRepository<T, Long extends Serializable> extends MongoRepository<T, Long> {

}
