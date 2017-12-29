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

public interface CrudDao<E, Integer> {

	 List<E> getAll();

	 void save(E entity);

	 E findOne(Integer id);

	 void delete(Integer id);

}
