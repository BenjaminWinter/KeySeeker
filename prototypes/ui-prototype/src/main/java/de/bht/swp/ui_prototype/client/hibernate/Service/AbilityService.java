package de.bht.swp.ui_prototype.client.hibernate.Service;

import de.bht.swp.ui_prototype.client.hibernate.Mapping.Ability;
import de.bht.swp.ui_prototype.client.hibernate.dao.AbilityDAO;


/**
 * Service layer for Ability
 */
public class AbilityService {
	AbilityDAO abilityDAO = new AbilityDAO();

	/**
	 * Create a new ability or update an existing one
	 * 
	 * @param ability
	 *            ability to be persisted
	 */
	public void saveOrUpdateAbility(Ability ability) {
		abilityDAO.saveOrUpdateAbility(ability);
	}

	/**
	 * Retrieve an ability
	 * 
	 * @param abilityId
	 *            identifier of the ability to be retrieved
	 * @return ability represented by the identifier provided
	 */
	public Ability getAbility(long abilityId) {
		return abilityDAO.getAbility(abilityId);
	}

	/**
	 * Delete ability
	 * 
	 * @param ability
	 *            ability to be deleted
	 */
	public void deleteAbility(Ability ability) {
		abilityDAO.deleteAbility(ability);
	}
}