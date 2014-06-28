package de.bht.swp.ui_prototype.server.hibernate.DAO;

public interface GenericDAO<T> {
	
	void saveOrUpdate(T Object);
	
	T get(long Id);
	
	void delete(T Object);
}
