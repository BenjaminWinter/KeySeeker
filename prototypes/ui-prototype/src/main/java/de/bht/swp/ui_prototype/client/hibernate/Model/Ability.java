package de.bht.swp.ui_prototype.client.hibernate.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ABILITY")
public class Ability {
	
	@Id @GeneratedValue

	private long id;
	

	private int movesperturn;
	

	private int attack;
	
	private int life;

	public long getAbilityId() {
		return id;
	}

	public void setAbilityId(long abilityId) {
		id = abilityId;
	}

	public int getMovesperturn() {
		return movesperturn;
	}

	public void setMovesperturn(int movesperturn) {
		this.movesperturn = movesperturn;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	@Override
	public String toString() {
		return "Ability [AbilityId=" + id + ", movesperturn="
				+ movesperturn + ", attack=" + attack + ", life=" + life + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + attack;
		result = prime * result + life;
		result = prime * result + movesperturn;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ability other = (Ability) obj;
		if (id != other.id)
			return false;
		if (attack != other.attack)
			return false;
		if (life != other.life)
			return false;
		if (movesperturn != other.movesperturn)
			return false;
		return true;
	}
	
	
}
