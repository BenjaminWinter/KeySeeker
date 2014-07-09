package de.bht.swp.ui_prototype.server.hibernate.DAO;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import de.bht.swp.ui_prototype.client.DBObject.Account;
import de.bht.swp.ui_prototype.server.hibernate.Util.HibernateUtil;


/**
 * Data Access Object for Account
 */
public class AccountDAO extends GenericDAOImpl<Account>{

	public Account get(String name){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		return (Account) session.createCriteria(Account.class).add(Restrictions.eq("name",name)).uniqueResult();
		
	}
}
