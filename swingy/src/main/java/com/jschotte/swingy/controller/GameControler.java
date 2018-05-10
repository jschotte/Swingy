package com.jschotte.swingy.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.jschotte.swingy.model.Game;
import com.jschotte.swingy.model.character.heroFactory;
import com.jschotte.swingy.view.GUIView;

public class GameControler extends Controler
{
	private GUIView view;

	public GameControler(GUIView newview, Game game)
	{
		this.view = newview;
		this.game = game;
	
		try
    	{
			this.getHeroes();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		this.view.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.view.addWindowListener(new java.awt.event.WindowAdapter()
		{
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(view.getPanel(),"Are you sure to close this window?", "Really Closing?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
		        {
		        	saveHeroes();
		            System.exit(0);
		        }
		    }
		});
		this.view.GUISelection(game.getHeroes());
		this.view.getSelectHero().addActionListener(new SelectHeroListener());
		this.view.getNewHero().addActionListener(new newHeroListener());	
	}
	
	private class SelectHeroListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//saveHeroes();
			System.out.println("select");
			game.initGame(view.selectedHero);
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


}


