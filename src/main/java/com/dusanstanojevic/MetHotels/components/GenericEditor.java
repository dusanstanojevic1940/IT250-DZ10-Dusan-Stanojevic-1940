package com.dusanstanojevic.MetHotels.components;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.dusanstanojevic.MetHotels.dao.GenericDAO;
import com.dusanstanojevic.MetHotels.entities.AbstractEntity;

public class GenericEditor<T extends AbstractEntity> {
	@Inject
	private GenericDAO<T> genericDao;
	@Property
	@Persist
	private T bean;
	@Property
	private T row;
	
	@SuppressWarnings("unchecked")
	private Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];;

	public List<T> getGrid() {
		List<T> temp = genericDao.all(entityClass); 
		return temp;
	}
	
	@CommitAfter
	Object onActionFromDelete(int id) {
		genericDao.delete(id, entityClass); 
		return this;
	}
	
	@CommitAfter
	Object onActionFromEdit(int id) {
		bean = (T) genericDao.getElementById(id, entityClass);
		return this; 
	}
		
	@CommitAfter
	public Object onSuccess() {
		genericDao.saveOrUpdate(bean); 
		try {
			bean = (T) entityClass.newInstance(); 
		} catch (Exception ex) {
		}
		return this; 
	}
}
