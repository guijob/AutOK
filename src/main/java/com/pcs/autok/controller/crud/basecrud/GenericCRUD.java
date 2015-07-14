package com.pcs.autok.controller.crud.basecrud;

import java.io.Serializable;

import com.pcs.autok.model.Cliente;

public class GenericCRUD<T, PK extends Serializable> implements GenericDAO<Cliente, PK>{

	protected Class<T> entityClass;
	
	
	public GenericCRUD(Class<T> T) {
		this.entityClass = T;
	}
	
	@Override
	public Cliente create(Cliente cliente) {
		return null;
	};
	
	@Override
	public Cliente read(PK id) {
		return null;
	};
	
	@Override
	public Cliente update(Cliente cliente) {
		return null;
	};
	
	@Override
	public void delete(Cliente cliente) {

	};
	
}
