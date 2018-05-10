package com.jschotte.swingy.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import com.jschotte.swingy.artefact.Armor;
import com.jschotte.swingy.artefact.Artefact;
import com.jschotte.swingy.artefact.Helm;
import com.jschotte.swingy.artefact.Weapon;
import com.jschotte.swingy.model.Game;
import com.jschotte.swingy.model.character.Hero;
import com.jschotte.swingy.model.character.heroFactory;

public class Controler
{
	protected Game game;
	
	public void getHeroes() throws IOException
	{
		try
		{
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader("heroes.txt"));
			String line;
			while ((line = reader.readLine()) != null)
			{
				String split[] = line.split(",");
				game.addHero(heroFactory.newHero(split[0],
						split[1],
						Integer.valueOf(split[2]),
						Integer.valueOf(split[3]),
						Integer.valueOf(split[4]),
						split[5],
						split[6],
						split[7]));
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	public void updatePosPlayer(int direction)
	{
		switch(direction)
		{
			case 0:
				this.game.setPosHeroy(this.game.getPosHeroy() - 1);
				break;
			case 1:
				this.game.setPosHeroy(this.game.getPosHeroy() + 1);
				break;
			case 2:
				this.game.setPosHerox(this.game.getPosHerox() + 1);
				break;
			default:
				this.game.setPosHerox(this.game.getPosHerox() - 1);
				break;
		}

	}
	
	public void setItem(Artefact artefact)
	{
		if (artefact instanceof Weapon)
			this.game.getCurrentHero().setWeapon((Weapon) artefact);
		else if (artefact instanceof Armor)
				this.game.getCurrentHero().setArmor((Armor) artefact);
		else 
			this.game.getCurrentHero().setHelm((Helm) artefact);
	}
	
	public void saveHeroes() 
	{
		try
		{
			File file = new File("heroes.txt");
			FileOutputStream output = new FileOutputStream(file, false);
		
			for (Hero hero: game.getHeroes())
			{
				String s = hero.getName() + ","
						 + hero.getClass().getSimpleName()+ ","
						 + hero.getLevel() + ","
						 + hero.getExp() + ","
						 + hero.getHitPoints() + ",";
				if (hero.getWeapon() == null)
					s += "null,";
				else
					s += hero.getWeapon().getName() + ",";
				if (hero.getArmor() == null)
					s += "null,";
				else
					s += hero.getArmor().getName() + ",";
				if (hero.getHelm() == null)
					s += "null\n";
				else
					s += hero.getHelm().getName() + "\n";
				output.write(s.getBytes());
			}
			output.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
