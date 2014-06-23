package persistence;

import java.io.File;

import org.hibernate.Session;

import de.bht.swp.ui_prototype.client.hibernate.Mapping.Ability;
import de.bht.swp.ui_prototype.client.hibernate.Mapping.Account;
import de.bht.swp.ui_prototype.client.hibernate.Mapping.Hero;
import de.bht.swp.ui_prototype.client.hibernate.Mapping.Image;
import de.bht.swp.ui_prototype.client.hibernate.Service.AccountService;
import de.bht.swp.ui_prototype.client.hibernate.Service.HeroService;
import de.bht.swp.ui_prototype.client.hibernate.Util.HibernateUtil;


/**
 * Parent class for Service Tests that contains helper methods
 */
public abstract class ServiceTest {
	/**
	 * Build an account
	 * @return account
	 */
	protected Account buildAccount() {
		Account account = new Account();
		account.setAccountName("test");
		account.setEmail("test@test.com");
		account.setPassword("1234");
		return account;
	}

	/**
	 * Create an account
	 * @return account that was created
	 */
	protected Account createAccount(){
		AccountService accountService = new AccountService();
		Account account = buildAccount();
		accountService.saveOrUpdateAccount(account);
		return account;
	}
	
	/**
	 * Delete an account
	 * @param account account to be deleted
	 */
	protected void deleteAccount(Account account) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		AccountService accountService = new AccountService();
		accountService.deleteAccount(account);
		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();
	}
}
