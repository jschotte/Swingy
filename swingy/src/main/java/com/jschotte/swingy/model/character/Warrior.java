package com.jschotte.swingy.model.character;

public class Warrior extends Hero
{
	private static int baseAttack = 10;
	private static int baseDefense = 3;
	private static int baseHp = 20;
	
	private static int attackLevel = 5;
	private static int defenseLevel = 2;
	private static int hpLevel = 5;
	
	public Warrior(String name, int level, int exp, int hp, String weapon, String armor, String helm)
	{
		super(name, level, exp, hp, baseAttack, baseDefense, baseHp, attackLevel, defenseLevel, hpLevel, weapon, armor, helm);
	}

	public Warrior(String name)
	{
		super(name, baseAttack, baseDefense, baseHp, attackLevel, defenseLevel, hpLevel);
	}
}
