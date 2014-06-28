package de.bht.swp.ui_prototype.server.hibernate.DAO;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;

import de.bht.swp.ui_prototype.server.hibernate.Util.Action;
import de.bht.swp.ui_prototype.server.hibernate.Util.HibernateUtil;
import de.bht.swp.ui_prototype.server.hibernate.Util.TransactionWrapper;

public class GenericDAOImpl<T> implements GenericDAO<T> {

	private Class<T> type;
	
	private TransactionWrapper tw = new TransactionWrapper();
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }
	public void saveOrUpdate(final T Object) {
		Action transaction = new Action(){

			@Override
			public java.lang.Object execute(Session session) {
				session.saveOrUpdate(Object);
				return null;
			}
			
		};
		tw.run(transaction);
	}

	@SuppressWarnings("unchecked")
	public T get(final long Id) {
		Action transaction = new Action(){

			@Override
			public Object execute(Session session) {
				return session.get(type, Id);
			}
		};
		return (T) tw.run(transaction);
	}

	public void delete(final T Object) {
		Action transaction = new Action(){

			@Override
			public java.lang.Object execute(Session session) {
				session.delete(Object);
				return null;
			}
			
		};
		tw.run(transaction);
	}

}
