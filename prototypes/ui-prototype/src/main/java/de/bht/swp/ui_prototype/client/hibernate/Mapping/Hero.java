package de.bht.swp.ui_prototype.client.hibernate.Mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@ForeignKey(name = "IMAGE_ID")
	private Image image;
	
	@ForeignKey(name = "ABILITY_ID")
	private Ability ability;

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

	@Override
	public String toString() {
		return "Hero [characterId=" + characterId + ", name=" + name
				+ ", image=" + image + ", ability=" + ability + "]";
	}
	
	
}
