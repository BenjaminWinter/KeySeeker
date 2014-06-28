package de.bht.swp.ui_prototype.server.hibernate.Util;

import de.bht.swp.ui_prototype.server.hibernate.DAO.AbilityDAO;
import de.bht.swp.ui_prototype.server.hibernate.DAO.AccountDAO;
import de.bht.swp.ui_prototype.server.hibernate.DAO.HeroDAO;
import de.bht.swp.ui_prototype.server.hibernate.DAO.ImageDAO;
import de.bht.swp.ui_prototype.server.hibernate.DAO.ItemDAO;



public class DAOFactory {

	public AccountDAO getAccountDAO() {
		return new AccountDAO();
	}

	public AbilityDAO getAbilityDAO() {
		return new AbilityDAO();
	}

	public HeroDAO getHeroDAO() {
		return new HeroDAO();
	}

	public ImageDAO getImageDAO() {
		return new ImageDAO();
	}

	public ItemDAO getItemDAO() {
		return new ItemDAO();
	}
}
