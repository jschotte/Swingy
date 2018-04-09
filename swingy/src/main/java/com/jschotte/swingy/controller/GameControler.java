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

public class GameControler extends Controler
{
	private Game game;
	private GUIView view;

	public GameControler(GUIView view, Game game)
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

		this.view.GUISelection(game.getHeroes());
		this.view.getSelectHero().addActionListener(new SelectHeroListener());
		this.view.getNewHero().addActionListener(new newHeroListener());	
	}
	
	private class SelectHeroListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("select");
		}
	}
	
	private class newHeroListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			view.GUICreationHero();
			view.getCreateHero().addActionListener(new createHeroListener());
		}	
	}
	
	private class createHeroListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			game.addHero(heroFactory.newHero(((GUIView)view).getHeroName().getText(), ((GUIView)view).getClassLst().getSelectedItem().toString()));
			view.GUISelection(game.getHeroes());
    		view.getSelectHero().addActionListener(new SelectHeroListener());
    		view.getNewHero().addActionListener(new newHeroListener());	
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


