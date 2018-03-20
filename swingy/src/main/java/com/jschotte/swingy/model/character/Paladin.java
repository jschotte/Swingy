package com.jschotte.swingy.model.character;

public class Paladin extends Hero
{
	private static int baseAttack = 5;
	private static int baseDefense = 7;
	private static int baseHp = 25;
	
	private static int attackLevel = 2;
	private static int defenseLevel = 4;
	private static int hpLevel = 10;
	
	public Paladin(String name, int level, int exp, int hp)
	{
		super(name, level, exp, hp, baseAttack, baseDefense, baseHp, attackLevel, defenseLevel, hpLevel);
	}
	
	public Paladin(String name)
	{
		super(name, baseAttack, baseDefense, baseHp, attackLevel, defenseLevel, hpLevel);
	}
}
