package com.jschotte.swingy.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jschotte.swingy.model.character.Hero;

public class GUIView extends JFrame implements ViewInterface
{
	private JPanel panel;
	private JButton selectHero;
	private JButton newHero;
	
	public GUIView()
	{
		this.panel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		
		selectHero = new JButton();
		selectHero.setText("select hero");
		this.panel.add(selectHero);
		//selectHero.addActionListener(show);
		
		newHero = new JButton();
		newHero.setText("create hero");
		this.panel.add(newHero);
		
		this.add(panel);
		this.setVisible(true);
	}

	public int showHeroes(ArrayList<Hero> heroes)
	{
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
		return null;
	}
	
	void addSelectHeroListener(ActionListener listenSelect)
	{
		selectHero.addActionListener(listenSelect);
	}
}