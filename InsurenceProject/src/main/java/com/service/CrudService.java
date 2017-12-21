package com.service;

import java.util.List;

public interface CrudService <E, ID> {

	 List<E> getAll();

	 void save(E entity);

	 E findOne(ID id);

	 void delete(ID id);


}
