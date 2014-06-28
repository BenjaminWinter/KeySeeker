package de.bht.swp.ui_prototype.client.hibernate.Service;

import de.bht.swp.ui_prototype.client.hibernate.Model.Account;
import de.bht.swp.ui_prototype.client.hibernate.dao.AccountDAO;
import de.bht.swp.ui_prototype.client.hibernate.dao.DAOFactory;


/**
 * Service layer for Account
 */
public class AccountService {
	AccountDAO accountDAO = new DAOFactory().getAccountDAO();

	/**
	 * Create a new account or update an existing one
	 * 
	 * @param account
	 *            account to be persisted
	 */
	public void saveOrUpdateAccount(Account account) {
		accountDAO.saveOrUpdate(account);
	}

	/**
	 * Retrieve an account
	 * 
	 * @param accountId
	 *            identifier of the account to be retrieved
	 * @return account represented by the identifier provided
	 */
	public Account getAccount(long accountId) {
		return accountDAO.get(accountId);
	}

	/**
	 * Delete account
	 * 
	 * @param account
	 *            account to be deleted
	 */
	public void deleteAccount(Account account) {
		accountDAO.delete(account);
	}
}
