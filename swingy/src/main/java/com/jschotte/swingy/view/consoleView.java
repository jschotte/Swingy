package com.jschotte.swingy.view;

import java.util.ArrayList;

import com.jschotte.swingy.model.character.Hero;
import com.jschotte.swingy.model.character.heroFactory;

public class consoleView
{

	public int showHeroes(ArrayList<Hero> heroes)
	{
		int i = 1;
		System.out.println("Select one Hero below or create new");
		System.out.println("0] Create new");
		for (Hero hero : heroes)
		{
			System.out.println(i + "] " +
					hero.getName() + "(" + hero.getClass().getSimpleName() + "), lv: "
					+ hero.getLevel() + ", exp: " + hero.getExp() + ", dmg: "
					+ hero.getAttack() + " , def: " + hero.getDefense() + ", hp:"
					+ hero.getHitPoints() + "(" + hero.getMaxHitPoints() + "), weapon: "
					+ hero.getWeapon() + ", armor: " + hero.getArmor() + ", helm: "
					+ hero.getHelm() + ".");
			i++;
		}
		try
		{
			int num = Integer.parseInt(System.console().readLine());
			return (num);
		}
		catch(Exception e)
		{
			return (-1);
		}
	}
	
	public Hero createHero()
	{
		System.out.println("Enter the name of your heroes");
		String heroname = System.console().readLine();
		System.out.println("Choose the class of your heroes");
		String heroclass = System.console().readLine();
		
		return (heroFactory.newHero(heroname, heroclass));
	}

}
