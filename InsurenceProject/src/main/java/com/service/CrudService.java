package com.service;

import java.util.List;
/**
 * Created by Sviatoslav on 23.04.2017.
 */
public interface CrudService <E, ID> {
    E findOne(ID id);
    List<E> getAll();
    void save(E entity);
    void delete(ID id);
}
