package persistence;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import de.bht.swp.ui_prototype.client.DBObject.Account;
import de.bht.swp.ui_prototype.server.hibernate.Service.AccountService;
import de.bht.swp.ui_prototype.server.hibernate.Util.HibernateUtil;

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

		account.setAccountName("newtester");
		account.setEmail("new@testemail.de");
		account.setPassword("1111");

		Assert.assertTrue(account.getAccountId() == 0);

		// save the account
		// ---- --- -------
		AccountService accountService = new AccountService();
		accountService.saveOrUpdateAccount(account);

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

		Account account = createAccount();
		System.out.println("var account = " + account);

		AccountService accountService = new AccountService();
		Account anotherCopy = accountService.getAccount(account.getAccountId());

		System.out.println("var anotherCopy = " + anotherCopy);

		// make sure these are two separate instances
		// ---- ---- ----- --- --- -------- ---------
		Assert.assertTrue(account != anotherCopy);
		// cleanup
		// -------
		deleteAccount(account);
	}

	/**
	 * Test updating of account balance
	 */
	@Test
	public void testUpdateAccountName() {
		Account account = createAccount();
		System.out.println("var account = " + account.getAccountName());

		AccountService accountService = new AccountService();
		account.setAccountName("tester42");
		accountService.saveOrUpdateAccount(account);

		Account anotherCopy = accountService.getAccount(account.getAccountId());
		System.out.println("var anotherCopy = " + anotherCopy.getAccountName());

		// make sure the one we just pulled back
		// from the database has the updated balance
		// -----------------------------------------
		Assert.assertTrue(anotherCopy.getAccountName().equals("tester42"));

		// cleanup
		// -------
		deleteAccount(account);
	}

	/**
	 * Test update of account type. Account Type is set to update=false in
	 * Hibernate Mapping. Therefore, ensure that it does not get updated.
	 */
	@Test
	public void testUpdateAccountPassword() {

		Account account = createAccount();
		System.out.println("var account = " + account);

		AccountService accountService = new AccountService();
		account.setPassword("1111");
		accountService.saveOrUpdateAccount(account);

		Account anotherCopy = accountService.getAccount(account.getAccountId());
		System.out.println("var anotherCopy = " + anotherCopy);

		// make sure the one we just pulled back from
		// the database does have the updated balance
		// ----------------------------------------------
		Assert.assertTrue(anotherCopy.getPassword().equals("1111"));

		// cleanup
		// -------
		deleteAccount(account);
	}

	/**
	 * Test deletion of account
	 */
	@Test
	public void testDeleteAccount() {

		Account account = createAccount();
		System.out.println("var account = " + account);

		// delete the account
		// ------ --- -------
		AccountService accountService = new AccountService();
		accountService.deleteAccount(account);


		// try to get the account again -- should be null
		// --- -- --- --- ------- ----- -- ------ -- ----

		Account anotherCopy = accountService.getAccount(account.getAccountId());

		System.out.println("var anotherCopy = " + anotherCopy);

		Assert.assertNull(anotherCopy);
	}
}
