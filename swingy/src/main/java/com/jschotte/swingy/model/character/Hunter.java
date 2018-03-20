package com.jschotte.swingy.model.character;

public class Hunter extends Hero
{
	private static int baseAttack = 20;
	private static int baseDefense = 1;
	private static int baseHp = 10;
	
	private static int attackLevel = 6;
	private static int defenseLevel = 2;
	private static int hpLevel = 3;
	
	public Hunter(String name, int level, int exp, int hp)
	{
		super(name, level, exp, hp, baseAttack, baseDefense, baseHp, attackLevel, defenseLevel, hpLevel);
	}
	
	public Hunter(String name)
	{
		super(name, baseAttack, baseDefense, baseHp, attackLevel, defenseLevel, hpLevel);
	}
}
