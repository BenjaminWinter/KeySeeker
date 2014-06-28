package de.bht.swp.ui_prototype.client.hibernate.Service;

import de.bht.swp.ui_prototype.client.hibernate.Mapping.Hero;
import de.bht.swp.ui_prototype.client.hibernate.dao.DAOFactory;
import de.bht.swp.ui_prototype.client.hibernate.dao.HeroDAO;


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
