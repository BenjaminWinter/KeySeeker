package de.bht.swp.ui_prototype.client.hibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;

import de.bht.swp.ui_prototype.client.hibernate.Util.HibernateUtil;

public class GenericDAOImpl<T> implements GenericDAO<T> {

	private Class<T> type;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }
	public void saveOrUpdate(T Object) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(Object);
		
	}

	@SuppressWarnings("unchecked")
	public T get(long Id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		return (T) session.get(type, Id);
	}

	public void delete(T Object) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(Object);
		
	}

}
