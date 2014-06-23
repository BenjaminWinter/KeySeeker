package de.bht.swp.ui_prototype.client.hibernate.dao;

import org.hibernate.Session;

import de.bht.swp.ui_prototype.client.hibernate.Mapping.Ability;
import de.bht.swp.ui_prototype.client.hibernate.Mapping.Account;
import de.bht.swp.ui_prototype.client.hibernate.Util.HibernateUtil;

/**
 * Data Access Object for ability
 */
public class AbilityDAO {

	/**
	 * Create a new ability or update an existing one
	 * 
	 * @param ability
	 *            ability to be persisted
	 */
	public void saveOrUpdateAbility(Ability ability) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(ability);
	}

	/**
	 * Retrieve an account from the data store
	 * 
	 * @param accountId
	 *            identifier of the account to be retrieved
	 * @return account represented by the identifier provided
	 */
	public Ability getAbility(long abilityId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Ability ability = (Ability) session.get(Account.class, abilityId);
		return ability;
	}

	/**
	 * Delete account from data store
	 * 
	 * @param account
	 *            account to be deleted
	 */
	public void deleteAbility(Ability ability) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(ability);
	}
	
}
