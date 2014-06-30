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
		if(isValidEmail(account.getEmail())){
			if(isValidAccName(account.getAccountName())){
				if(isValidPassword(account.getPassword())){
					accountDAO.saveOrUpdate(account);
				} else {
					throw new IllegalArgumentException("Password invalid");
				}
				
			} else {
				throw new IllegalArgumentException("AccountName is invalid");
			}
		} else {
			throw new IllegalArgumentException("Email is Invalid");
		}
		
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
	private static boolean isValidEmail(String emailAddress) {
	    return emailAddress.contains(" ") == false && emailAddress.matches(".+@.+\\.[a-z]+");
	}
	private static boolean isValidAccName(String accname){
		return accname.contains(" ") == false && accname.length() > 2 && accname.length() < 12;
	}
	
	private static boolean isValidPassword(String password){
		return password.length() > 0;
	}
}
