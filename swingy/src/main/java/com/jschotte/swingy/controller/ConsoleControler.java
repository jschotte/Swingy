package com.jschotte.swingy.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.jschotte.swingy.model.Game;
import com.jschotte.swingy.model.character.heroFactory;
import com.jschotte.swingy.view.GUIView;
import com.jschotte.swingy.view.consoleView;

public class ConsoleControler extends Controler
{
	private Game game;
	private consoleView view;

	public ConsoleControler(consoleView view, Game game)
	{
		this.view = view;
		this.game = game;
	
    	try
    	{
			this.getHeroes();
		}
    	catch (IOException e)
    	{
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
			System.out.println("index invalid");
			this.homeSelection();
		}
		else
		{
			System.out.println("start game");
		}
	}
	
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
				game.addHero(heroFactory.newHero(split[0], split[1], Integer.valueOf(split[2]), Integer.valueOf(split[3]), Integer.valueOf(split[4])));
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
}


