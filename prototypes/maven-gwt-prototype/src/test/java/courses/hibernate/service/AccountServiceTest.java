package courses.hibernate.service;

import java.util.Date;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import courses.hibernate.service.AccountService;
import courses.hibernate.util.HibernateUtil;
import courses.hibernate.vo.Account;

/**
 * Service layer tests for Account
 */
public class AccountServiceTest extends ServiceTest {

	/**
	 * Test account creation
	 */
	@Test
	public void testCreateAccount() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// create the account
		// ------ --- -------
		Account account = new Account();

		// no need to set id, Hibernate does it for us
		// -- ---- -- --- --- --------- ---- -- --- --
		// account.setAccountId(1)

		account.setAccountType(Account.ACCOUNT_TYPE_SAVINGS);
		account.setCreationDate(new Date());
		account.setBalance(1000L);

		Assert.assertTrue(account.getAccountId() == 0);

		// save the account
		// ---- --- -------
		AccountService accountService = new AccountService();
		accountService.saveOrUpdateAccount(account);

		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

		System.out.println("var account = " + account);

		// check that IDs were set after the hbm session
		// ----- ---- --- ---- --- ----- --- --- -------
		Assert.assertTrue(account.getAccountId() > 0);

		// cleanup
		// -------
		deleteAccount(account);
	}

	/**
	 * Test retrieval of account
	 */
	@Test
	public void testGetAccount() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Account account = createAccount();
		System.out.println("var account = " + account);

		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		AccountService accountService = new AccountService();
		Account anotherCopy = accountService.getAccount(account.getAccountId());

		System.out.println("var anotherCopy = " + anotherCopy);

		// make sure these are two separate instances
		// ---- ---- ----- --- --- -------- ---------
		Assert.assertTrue(account != anotherCopy);

		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

		// cleanup
		// -------
		deleteAccount(account);
	}

	/**
	 * Test updating of account balance
	 */
	@Test
	public void testUpdateAccountBalance() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Account account = createAccount();
		System.out.println("var account = " + account);

		AccountService accountService = new AccountService();
		account.setBalance(2000);
		accountService.saveOrUpdateAccount(account);
		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

		Session session2 = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		session2.beginTransaction();

		Account anotherCopy = accountService.getAccount(account.getAccountId());
		System.out.println("var anotherCopy = " + anotherCopy);

		// make sure the one we just pulled back
		// from the database has the updated balance
		// -----------------------------------------
		Assert.assertTrue(anotherCopy.getBalance() == 2000);

		session2.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

		// cleanup
		// -------
		deleteAccount(account);
	}

	/**
	 * Test update of account type. Account Type is set to update=false in
	 * Hibernate Mapping. Therefore, ensure that it does not get updated.
	 */
	@Test
	public void testUpdateAccountType() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Account account = createAccount();
		System.out.println("var account = " + account);

		AccountService accountService = new AccountService();
		account.setAccountType(Account.ACCOUNT_TYPE_CHECKING);
		accountService.saveOrUpdateAccount(account);
		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

		Session session2 = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		session2.beginTransaction();

		Account anotherCopy = accountService.getAccount(account.getAccountId());
		System.out.println("var anotherCopy = " + anotherCopy);

		// make sure the one we just pulled back from
		// the database does have the updated balance
		// ----------------------------------------------
		Assert.assertTrue(anotherCopy.getAccountType().equals(
				Account.ACCOUNT_TYPE_CHECKING));

		session2.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

		// cleanup
		// -------
		deleteAccount(account);
	}

	/**
	 * Test deletion of account
	 */
	@Test
	public void testDeleteAccount() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Account account = createAccount();
		System.out.println("var account = " + account);

		// delete the account
		// ------ --- -------
		AccountService accountService = new AccountService();
		accountService.deleteAccount(account);

		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

		// try to get the account again -- should be null
		// --- -- --- --- ------- ----- -- ------ -- ----
		Session session2 = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		session2.beginTransaction();

		Account anotherCopy = accountService.getAccount(account.getAccountId());

		System.out.println("var anotherCopy = " + anotherCopy);

		Assert.assertNull(anotherCopy);

		session2.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();
	}
}
