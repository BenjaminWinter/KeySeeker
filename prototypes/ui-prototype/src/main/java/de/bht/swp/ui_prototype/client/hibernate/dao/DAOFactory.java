package de.bht.swp.ui_prototype.client.hibernate.dao;



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
