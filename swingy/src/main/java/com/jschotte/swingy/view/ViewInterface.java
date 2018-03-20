package com.jschotte.swingy.view;

import java.util.ArrayList;

import com.jschotte.swingy.model.character.Hero;

public interface ViewInterface
{
	public int showHeroes(ArrayList<Hero> heroes);
	public Hero createHero();
}
