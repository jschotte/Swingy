package com.jschotte.swingy.model.character;

import com.jschotte.swingy.utils.customException;

public class heroFactory
{
	public enum classes {Paladin, Mage, Warrior, Hunter};
			
	static public Hero newHero(String name, String type, int level, int exp, int hp, String weapon, String armor, String helm)
	{
		Hero hero;
		
		switch(type)
		{
			case "Warrior":
				hero = new Warrior(name, level, exp, hp, weapon, armor, helm);
				break;
			case "Mage":
				hero = new Mage(name, level, exp, hp, weapon, armor, helm);
				break;
			case "Paladin":
				hero = new Paladin(name, level, exp, hp, weapon, armor, helm);
				break;
			case "Hunter":
				hero = new Hunter(name, level, exp, hp, weapon, armor, helm);
				break;
			default:
				throw new customException("hero type unknown");
		}
		return hero;
	}
	
	static public Hero newHero(String name, String type)
	{
		Hero hero;
		
		switch(type)
		{
			case "Warrior":
				hero = new Warrior(name);
				break;
			case "Mage":
				hero = new Mage(name);
				break;
			case "Paladin":
				hero = new Paladin(name);
				break;
			case "Hunter":
				hero = new Hunter(name);
				break;
			default:
				throw new customException("hero type unknown");
		}
		return hero;
	}
}
