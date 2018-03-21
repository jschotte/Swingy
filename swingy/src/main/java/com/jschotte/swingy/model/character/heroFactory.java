package com.jschotte.swingy.model.character;

import com.jschotte.swingy.utils.customException;

public class heroFactory
{
	public enum classes {Paladin, Mage, Warrior, Hunter};
			
	static public Hero newHero(String name, String type, int level, int exp, int hp)
	{
		Hero hero;
		
		switch(type)
		{
			case "Warrior":
				hero = new Warrior(name, level, exp, hp);
				break;
			case "Mage":
				hero = new Mage(name, level, exp, hp);
				break;
			case "Paladin":
				hero = new Paladin(name, level, exp, hp);
				break;
			case "Hunter":
				hero = new Hunter(name, level, exp, hp);
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
