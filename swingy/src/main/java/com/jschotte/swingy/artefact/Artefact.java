package com.jschotte.swingy.artefact;

public abstract class Artefact
{
	private String name;
	private int attack;
	private int defense;
	private int hp;
	
	public Artefact(String name, int bonusAttack, int bonusDefense, int bonusHp)
	{
		this.setName(name);
		this.setAttack(bonusAttack);
		this.setDefense(bonusDefense);
		this.setHp(bonusHp);
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString()
	{
		return this.name + "(" + this.attack + ", " + this.defense + ", " + this.hp + ")"; 
	}
}
