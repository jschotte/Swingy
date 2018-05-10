package com.jschotte.swingy.artefact;

public abstract class Weapon extends Artefact
{
	public Weapon(String name, int bonusAttack, int bonusDefense, int bonusHp)
	{
		super(name, bonusAttack, bonusDefense, bonusHp);
	}

}
