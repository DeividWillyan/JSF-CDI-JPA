package org.jsf.repository;

import java.util.List;

public interface GenericRepository<T> {

	T save(T obj);
	T edit(T obj);
	T findOne(Long id);
	List<T> findAll();
	boolean remove(T obj);

}
