package com.heimu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Legends {
	private int id;
	private String heroname;
	private String herodesc;
	private String position;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeroname() {
		return heroname;
	}
	public void setHeroname(String heroname) {
		this.heroname = heroname;
	}
	public String getHerodesc() {
		return herodesc;
	}
	public void setHerodesc(String herodesc) {
		this.herodesc = herodesc;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}