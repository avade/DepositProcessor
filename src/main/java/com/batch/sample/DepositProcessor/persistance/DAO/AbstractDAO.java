package com.batch.sample.DepositProcessor.persistance.DAO;

import java.io.Serializable;
import java.util.List;

public interface AbstractDAO< T extends Serializable > {

	   public void setClazz( final Class< T > clazzToSet );
		   
		   public T findOne( final Long id );
		   
		   public List< T > findAll();
		   
		   public void save( final T entity );
		   
		   public void update( final T entity );
		   
		   public void delete( final T entity );
		   
		   public void deleteById( final Long entityId );
		
}
