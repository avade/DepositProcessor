package com.batch.sample.DepositProcessor.persistance.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.batch.sample.DepositProcessor.persistance.DAO.AbstractDAO;


/**
 * @author alex.d.ley
 * Implementation of the AbstractDAO for Hibernate. This class aims 
 * to provide generic methods that can be reused across DAO's.
 * @param <T>
 */
public abstract class AbstractHibernateDAO< T extends Serializable >  implements AbstractDAO<T> {
	 private Class< T > clazz;
	   
	   @Autowired
	   SessionFactory sessionFactory;
	   
	   public void setClazz( final Class< T > clazzToSet ){
	      clazz = clazzToSet;
	   }
	   
	public Class<T> getClazz(){
		      return this.clazz;
		   }
	   
	   @SuppressWarnings("unchecked")
	public T findOne( final Long id ){
		   
		   if(id != null ){
			   return (T) getCurrentSession().get( clazz, id );
		   }else{
			   return null;
		   }
	   }
	   
	   @SuppressWarnings("unchecked")
	public List< T > findAll(){
	      return getCurrentSession().createQuery( "from " + clazz.getName() ).list();
	   }
	   
	   public void save( final T entity ){
		   if(entity != null )
	      getCurrentSession().save( entity );
	   }
	   
	   public void update( final T entity ){
		   if(entity != null )
	      getCurrentSession().merge( entity );
	   }
	   
	   public void delete( final T entity ){
		   if(entity != null )
	      getCurrentSession().delete( entity );
	   }
	   public void deleteById( final Long entityId ){
	      final T entity = findOne( entityId );
	      if(entity != null )
	      delete( entity );
	   }
	

	protected final Session getCurrentSession(){
	      return sessionFactory.getCurrentSession();
	   }

}
