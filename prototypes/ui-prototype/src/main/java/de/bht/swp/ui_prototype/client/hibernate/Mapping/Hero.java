package de.bht.swp.ui_prototype.client.hibernate.Mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

/**
 * @author benny
 *
 */
@Entity
@Table(name = "CHARACTER")
public class Hero {
	
	@Id @GeneratedValue
	@Column(name = "CHARACTER_ID")
	private long characterId;
	
	@Column(name = "NAME")
	private String name;
	
	@OneToOne
	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "IMAGE_ID")
	private Image image;
	
	@OneToOne
	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "ABILITY_ID")
	private Ability ability;
	
	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;

	public long getCharacterId() {
		return characterId;
	}

	public void setCharacterId(long characterId) {
		this.characterId = characterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Ability getAbility() {
		return ability;
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account){
		this.account = account;
	}

	@Override
	public String toString() {
		return "Hero [characterId=" + characterId + ", name=" + name
				+ ", image=" + image + ", ability=" + ability + "]";
	}
	
	
}
