package de.bht.swp.ui_prototype.server.hibernate.Util;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionWrapper{
	
	public Object run(Action action) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		Object result = null;
		
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			result = action.execute(session);
			transaction.commit();
		} catch (Exception e){
			if(transaction != null){
				transaction.rollback();
				result = null;
				System.err.println(e.getMessage());
			}
		} finally {
			if(session.isOpen()){
				session.close();	
			}
		}
		return result;
		
	}
}
