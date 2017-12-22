/**  
 * 
 * Generic interface
 * for repeated part of code.
 * 
 * Written by S.Naida
 * 
 * */

package com.dao;

import java.util.List;

public interface CrudDao<E, ID> {

	 List<E> getAll();

	 void save(E entity);

	 E findOne(ID id);

	 void delete(ID id);

}
