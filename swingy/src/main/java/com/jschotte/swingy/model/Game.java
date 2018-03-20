package com.jschotte.swingy.model;

import java.util.*;

import com.jschotte.swingy.model.character.Hero;


public class Game
{
	private ArrayList<Hero> heroes = new ArrayList<Hero>();

	public ArrayList<Hero> getHeroes()
	{
		return heroes;
	}

	public void addHero(Hero hero)
	{
		heroes.add(hero);
	}
}
