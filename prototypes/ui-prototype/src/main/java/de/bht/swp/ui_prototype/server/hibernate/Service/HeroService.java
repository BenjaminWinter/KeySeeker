package de.bht.swp.ui_prototype.server.hibernate.Service;

import de.bht.swp.ui_prototype.client.DBObject.Hero;
import de.bht.swp.ui_prototype.server.hibernate.DAO.HeroDAO;
import de.bht.swp.ui_prototype.server.hibernate.Util.DAOFactory;


/**
 * Service layer for Hero
 */
public class HeroService {
	HeroDAO heroDAO = new DAOFactory().getHeroDAO();

	/**
	 * Create a new hero or update an existing one
	 * 
	 * @param hero
	 *            hero to be persisted
	 */
	public void saveOrUpdateHero(Hero hero) {
		heroDAO.saveOrUpdate(hero);
	}

	/**
	 * Retrieve an hero
	 * 
	 * @param heroId
	 *            identifier of the hero to be retrieved
	 * @return hero represented by the identifier provided
	 */
	public Hero getHero(long heroId) {
		return heroDAO.get(heroId);
	}

	/**
	 * Delete hero
	 * 
	 * @param hero
	 *            hero to be deleted
	 */
	public void deleteHero(Hero hero) {
		heroDAO.delete(hero);
	}
}
