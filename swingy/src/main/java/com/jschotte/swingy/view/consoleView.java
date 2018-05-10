package com.jschotte.swingy.view;

import java.util.ArrayList;

import com.jschotte.swingy.artefact.Artefact;
import com.jschotte.swingy.model.Game;
import com.jschotte.swingy.model.Vilain;
import com.jschotte.swingy.model.character.Hero;
import com.jschotte.swingy.model.character.heroFactory;

public class consoleView
{
	public String showHero(Hero hero)
	{
		String s = hero.getName() + "(" + hero.getClass().getSimpleName() + "), lv: "
				+ hero.getLevel() + ", exp: " + hero.getExp() + ", dmg: "
				+ hero.getAttack() + " , def: " + hero.getDefense() + ", hp:"
				+ hero.getHitPoints() + "(" + hero.getMaxHitPoints() + "), weapon: "
				+ hero.getWeapon() + ", armor: " + hero.getArmor() + ", helm: "
				+ hero.getHelm() + ".";
		return s;
	}
	public int showHeroes(ArrayList<Hero> heroes)
	{
		int i = 1;
		System.out.println("Select one Hero below or create new");
		System.out.println("0] Create new");
		for (Hero hero : heroes)
		{
			System.out.println(i + "] " + showHero(hero));
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
	
	public void displayMap(Game game)
	{
		
		for (int y = 0; y < game.getSizeMap(); y++)
		{
			for (int x = 0; x < game.getSizeMap(); x++)
			{
				System.out.print("|");
				if (game.getMap()[x][y] == 2)
					System.out.print("0");
				else
					System.out.print(game.getMap()[x][y]);
			}
			System.out.println("|");
		}
	}
	
	public int mainGame(Game game)
	{
		
		System.out.println(showHero(game.getCurrentHero()));
		displayMap(game);
		System.out.println("Choose direction:");
		System.out.println("0] North");
		System.out.println("1] South");
		System.out.println("2] East");
		System.out.println("3] West");
		System.out.println("4] Exit");
		
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
	
	public int chooseFight(Vilain v)
	{
		System.out.println("Un ennemi avec une puissance de " + v.getPower() + " est present:");
		System.out.println("0] Fight");
		System.out.println("1] Run");
		
		try
		{
			int num = Integer.parseInt(System.console().readLine());
			clearScreen();
			return (num);
		}
		catch(Exception e)
		{
			return (-1);
		}
	}
	
	public int keepItem(Artefact artefact)
	{
		System.out.println("Vous avez gagne " + artefact.toString());
		System.out.println("Voulez vous l'equiper ?");
		System.out.println("0] Oui");
		System.out.println("1] Non");
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
	
	public void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	} 
}
