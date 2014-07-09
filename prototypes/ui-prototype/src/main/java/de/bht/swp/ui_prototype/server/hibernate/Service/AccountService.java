package de.bht.swp.ui_prototype.server.hibernate.Service;

import java.net.InetAddress;

import org.apache.tools.ant.taskdefs.email.EmailAddress;

import de.bht.swp.ui_prototype.client.DBObject.Account;
import de.bht.swp.ui_prototype.server.hibernate.DAO.AccountDAO;
import de.bht.swp.ui_prototype.server.hibernate.Util.DAOFactory;


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
	
	public Account getAccount(String name) {
		return accountDAO.get(name);
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
