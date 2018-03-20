package com.jschotte.swingy.model.character;

public class Mage extends Hero
{
	private static int baseAttack = 10;
	private static int baseDefense = 5;
	private static int baseHp = 15;
	
	private static int attackLevel = 4;
	private static int defenseLevel = 4;
	private static int hpLevel = 5;
	
	public Mage(String name, int level, int exp, int hp)
	{
		super(name, level, exp, hp, baseAttack, baseDefense, baseHp, attackLevel, defenseLevel, hpLevel);
	}
	
	public Mage(String name)
	{
		super(name, baseAttack, baseDefense, baseHp, attackLevel, defenseLevel, hpLevel);
	}
}
