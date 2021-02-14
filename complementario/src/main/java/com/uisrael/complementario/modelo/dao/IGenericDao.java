package com.uisrael.complementario.modelo.dao;

import java.util.List;

public interface IGenericDao <T>{
	
	public T create(T t);
	
	public T read (Object id);
	
	public T update (T t);
	
	public void delete(T t);
	
	
	public void commit();
	
	public void rollback();
	
	public void beginTransaction();
	
	public void closeTransaction();
	
	public void commitAndCloseTransaction();
	
	public void flush();
	
	public List<T> findAll();
}
