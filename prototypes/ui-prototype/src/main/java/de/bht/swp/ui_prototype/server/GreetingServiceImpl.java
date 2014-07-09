package de.bht.swp.ui_prototype.server;

import org.hibernate.Session;

import de.bht.swp.ui_prototype.client.GreetingService;
import de.bht.swp.ui_prototype.client.DBObject.Account;
import de.bht.swp.ui_prototype.server.hibernate.Service.AccountService;
import de.bht.swp.ui_prototype.server.hibernate.Util.Action;
import de.bht.swp.ui_prototype.server.hibernate.Util.TransactionWrapper;
import de.bht.swp.ui_prototype.shared.FieldVerifier;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
    GreetingService {
private TransactionWrapper tw = new TransactionWrapper();
private AccountService as = new AccountService();
  public String greetServer(String input) throws IllegalArgumentException {
    // Verify that the input is valid.
    if (!FieldVerifier.isValidName(input)) {
      // If the input is not valid, throw an IllegalArgumentException back to
      // the client.
      throw new IllegalArgumentException(
          "Name must be at least 4 characters long");
    }

    String serverInfo = getServletContext().getServerInfo();
    String userAgent = getThreadLocalRequest().getHeader("User-Agent");

    // Escape data from the client to avoid cross-site script vulnerabilities.
    input = escapeHtml(input);
    userAgent = escapeHtml(userAgent);

    return "Hello, " + input + "!<br><br>I am running " + serverInfo
        + ".<br><br>It looks like you are using:<br>" + userAgent;
  }

  /**
   * Escape an html string. Escaping data received from the client helps to
   * prevent cross-site script vulnerabilities.
   *
   * @param html the html string to escape
   * @return the escaped string
   */
  private String escapeHtml(String html) {
    if (html == null) {
      return null;
    }
    return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(
        ">", "&gt;");
  }

public String loginUser(final String name, String passwort)
		throws IllegalArgumentException {
	
	Action getAccount = new Action(){

		@Override
		public Object execute(Session session) {
		
			return as.getAccount(name);
		}
		
	};
	Object account = tw.run(getAccount);
	if (account == null){
		return "false";
	}

	String accPassword =  ((Account) account).getPassword();
	if (accPassword.equals(passwort)){
		return "true";
	}
	return "false";
}

public String registerUser(String name, String passwort,String email)
		throws IllegalArgumentException {
 
	final Account account = new Account();
	account.setAccountName(name);
	account.setEmail(email);
	account.setPassword(passwort);
	
	Action registerUser = new Action(){

		@Override
		public Object execute(Session session) {
			as.saveOrUpdateAccount(account);
			
			return null;
		}
		
	};
	Object result = tw.run(registerUser);
	if (result.equals("Transaction Error")){
		return "false";
	}
	
	return "true";
}


}
