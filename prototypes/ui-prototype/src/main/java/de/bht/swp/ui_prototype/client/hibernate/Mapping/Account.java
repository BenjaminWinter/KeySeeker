package de.bht.swp.ui_prototype.client.hibernate.Mapping;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


//import org.hibernate.annotations.Entity;
//import org.hibernate.annotations.ForeignKey;

/**
 * Domain object representing an Account
 */
@Entity
@Table(name = "ACCOUNT")
public class Account {
	
	@Id @GeneratedValue
	@Column(name = "ACCOUNT_ID")
	private long accountId;
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	public Account(){}
	/**
	 * Get accountId
	 * 
	 * @return accountId
	 */
	public long getAccountId() {
		return accountId;
	}

	/**
	 * Set accountId
	 * 
	 * @param accountId
	 */
	@SuppressWarnings("unused")
	private void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	/**
	 * Get accountName
	 * 
	 * @return accountName
	 */
	public String getAccountName() {
		return name;
	}

	/**
	 * Set accountNem
	 * 
	 * @param accountName
	 */
	public void setAccountName(String name) {
		this.name = name;
	}

	/**
	 * Get email
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get password
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
