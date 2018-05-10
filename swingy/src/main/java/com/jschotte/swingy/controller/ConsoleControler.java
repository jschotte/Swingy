package com.jschotte.swingy.controller;


import java.io.IOException;

import com.jschotte.swingy.artefact.Artefact;
import com.jschotte.swingy.model.Game;
import com.jschotte.swingy.model.Vilain;
import com.jschotte.swingy.view.consoleView;

public class ConsoleControler extends Controler
{
	private consoleView view;

	public ConsoleControler(consoleView view, Game game)
	{
		this.view = view;
		this.game = game;
	
    	try
    	{
			this.getHeroes();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	this.homeSelection();
	}
	
	public void homeSelection()
	{
		int ret = this.view.showHeroes(game.getHeroes());
		if (ret == 0)
		{
			this.game.addHero(this.view.createHero());
			this.homeSelection();
		}
		else if (ret < 0 || ret > this.game.getHeroes().size())
		{
			this.homeSelection();
		}
		else
		{
			this.game.initGame(this.game.getHeroes().get(ret - 1));
			this.view.clearScreen();
			this.main();
		}
	}
	
	public boolean fight(Vilain v)
	{
		int power = v.getPower();
		double base = 100 - (power * 7) + ((this.game.getCurrentHero().getDefense() + this.game.getCurrentHero().getAttack()) / 2);
		int rand = (int)(Math.random() * (100) + 1);
		//System.out.println(base + "% | " + rand + "/100");
		if (rand <= (int)base)
			return true;
		else
			return false;
	}
	
	public boolean run(Vilain v)
	{
		int rand = (int)(Math.random() * (2));
		if (rand == 1)
			return true;
		return false;
	}
	
	public void matchVictory(Vilain vilain)
	{
		System.out.println("Vous avez battu le vilain");
		int rand = (int)(Math.random() * (100) + 1);
		int oldlevel = this.game.getCurrentHero().getLevel();
		this.game.getCurrentHero().addExp(vilain.getPower() * 50);
		System.out.println("Vous avez gagne " + vilain.getPower() * 50 + " points d'experiences");
		int newlevel = this.game.getCurrentHero().getLevel();
		
		if (oldlevel != newlevel)
			System.out.println("Vous etes passes au level " + newlevel);
		if (rand <= vilain.getPower())
		{
			Artefact test = this.game.getArtefact().get((int)(Math.random() * (this.game.getArtefact().size())));
			int ret = this.view.keepItem(test);
			while (ret < 0 || ret > 1)
				ret = this.view.keepItem(test);
			if (ret == 0)
				this.setItem(test);
		}
	}
	
	public void matchdefeate()
	{
		System.out.println("Vous avez perdu contre le vilain, vous etes mort");
		this.game.getHeroes().remove(this.game.getCurrentHero());
		this.saveHeroes();
		System.exit(0);
	}
	
	public void main()
	{
		
		while (true)
		{
			int retgame = this.view.mainGame(game);
			while (retgame < 0 || retgame > 4)
			{
				this.view.clearScreen();
				retgame = this.view.mainGame(game);
			}
			if (retgame == 4)
				return;
			this.view.clearScreen();
			this.game.getMap()[this.game.getPosHerox()][this.game.getPosHeroy()] = 0;
			int oldx = this.game.getPosHerox();
			int oldy = this.game.getPosHeroy();
			this.updatePosPlayer(retgame);
			int ret;
			if (this.game.getMap()[this.game.getPosHerox()][this.game.getPosHeroy()] == 2)
			{
				Vilain vilain = null;
				for (Vilain v : this.game.getVilains())
				{
					if (v.getPosX() == this.game.getPosHerox() && v.getPosY() == this.game.getPosHeroy())
						vilain = v;
				}
				while ((ret = this.view.chooseFight(vilain)) < 0 || ret > 1)
				{
				}
				if (ret == 0)
				{
					if (fight(vilain) == true)
					{
						matchVictory(vilain);
					}
					else
					{
						matchdefeate();
					}
				}
				else
				{
					if (run(vilain) == true)
					{
						System.out.println("Vous avez reussit a vous echaper");
						this.game.setPosHerox(oldx);
						this.game.setPosHeroy(oldy);
					}
					else
					{
						System.out.println("Vous n'avez pas reussi a vous echaper, vous devez combatte le vilain");
						if (fight(vilain) == true)
						{
							matchVictory(vilain);
						}
						else
						{
							matchdefeate();
						}
					}
				}
			}
			this.game.getMap()[this.game.getPosHerox()][this.game.getPosHeroy()] = 1;
			if (this.game.getPosHerox() == 0 || this.game.getPosHerox() == this.game.getSizeMap() - 1
					|| this.game.getPosHeroy() == 0 || this.game.getPosHeroy() == this.game.getSizeMap() - 1)
			{
				System.out.println("Vous avez gagne !");
				return;
			}
			
		}
	}
}