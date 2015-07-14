package com.pcs.autok.controller.crud.basecrud;

import java.io.Serializable;


public interface GenericDAO<T, PK extends Serializable> {
	
	/* create generico */
	T create(T t);
	
	/* read generico */
	T read(PK id);
	
	/* update generico */
	T update(T t);
	
	/* delete generico */
	void delete( T t);
}
