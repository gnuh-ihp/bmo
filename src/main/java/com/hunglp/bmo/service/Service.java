package com.hunglp.bmo.service;

import java.io.Serializable;
import java.util.List;

public interface Service<T, Long extends Serializable> {

	List<T> getAll();
}
