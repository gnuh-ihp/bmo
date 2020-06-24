package com.hunglp.bmo.repository;

import java.io.Serializable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DefaultRepository<T, String extends Serializable> extends MongoRepository<T, String> {

}
