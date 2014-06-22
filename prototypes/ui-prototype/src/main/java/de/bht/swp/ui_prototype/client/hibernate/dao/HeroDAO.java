package de.bht.swp.ui_prototype.client.hibernate.dao;

import org.hibernate.Session;

import de.bht.swp.ui_prototype.client.hibernate.Mapping.Hero;
import de.bht.swp.ui_prototype.client.hibernate.Util.HibernateUtil;

/**
 * Data Access Object for Hero
 */
public class HeroDAO {

	/**
	 * Create a new hero or update an existing one
	 * 
	 * @param Hero
	 *            hero to be persisted
	 */
	public void saveOrUpdateHero(Hero hero) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(hero);
	}

	/**
	 * Retrieve an hero from the data store
	 * 
	 * @param heroId
	 *            identifier of the hero to be retrieved
	 * @return hero represented by the identifier provided
	 */
	public Hero getHero(long heroId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Hero hero = (Hero) session.get(Hero.class, heroId);
		return hero;
	}

	/**
	 * Delete hero from data store
	 * 
	 * @param hero
	 *            hero to be deleted
	 */
	public void deleteHero(Hero hero) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(hero);
	}
	
}
