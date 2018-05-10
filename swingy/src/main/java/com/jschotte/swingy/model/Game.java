package com.jschotte.swingy.model;

import java.util.*;

import com.jschotte.swingy.artefact.Artefact;
import com.jschotte.swingy.artefact.IronHelm;
import com.jschotte.swingy.artefact.Maille;
import com.jschotte.swingy.artefact.MasterSword;
import com.jschotte.swingy.model.character.Hero;


public class Game
{
	private ArrayList<Hero> heroes = new ArrayList<Hero>();
	
	private int sizeMap;
	private Hero currentHero;
	private int map[][];
	
	private int posHerox;
	private int posHeroy;
	
	private ArrayList<Vilain> vilains = new ArrayList<Vilain>();
	
	private ArrayList<Artefact> artefacts = new ArrayList<Artefact>();

	public ArrayList<Hero> getHeroes()
	{
		return heroes;
	}

	public void addHero(Hero hero)
	{
		heroes.add(hero);
	}
	
	public void initGame(Hero hero)
	{
		this.setCurrentHero(hero);
		this.sizeMap = (hero.getLevel()-1)*5+10-(hero.getLevel()%2);
		this.map = new int[this.sizeMap][this.sizeMap];
		
		this.posHerox = this.sizeMap / 2 ;
		this.posHeroy = this.sizeMap / 2 ;
		
		this.artefacts.add(new MasterSword());
		this.artefacts.add(new IronHelm());
		this.artefacts.add(new Maille());
		
		this.initMap();
	}
	
	public void initMap()
	{
		for (int x = 0; x < this.sizeMap; x++)
		{
			for (int y = 0; y < this.sizeMap; y++)
			{
				this.map[x][y] = 0;
			}
		}
		this.map[this.posHerox][this.posHeroy] = 1;
		this.initVilain();
	}
	
	public void initVilain()
	{
		for (int i = 0; i < this.sizeMap * 3 + this.sizeMap / 2; i++)
		{
			int x = (int)(Math.random() * (this.sizeMap));
			int y = (int)(Math.random() * (this.sizeMap));
			while (this.map[x][y] == 2 || this.map[x][y] == 1)
			{
				x = (int)(Math.random() * (this.sizeMap));
				y = (int)(Math.random() * (this.sizeMap));
			}
			this.map[x][y] = 2;
			this.vilains.add(new Vilain(x,y));
		}
	}
	
	public int getSizeMap()
	{
		return sizeMap;
	}

	public int getPosHeroy() {
		return posHeroy;
	}

	public void setPosHeroy(int posHeroy) {
		this.posHeroy = posHeroy;
	}

	public Hero getCurrentHero() {
		return currentHero;
	}

	public void setCurrentHero(Hero currentHero) {
		this.currentHero = currentHero;
	}

	public int getPosHerox() {
		return posHerox;
	}

	public void setPosHerox(int posHerox) {
		this.posHerox = posHerox;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int map[][]) {
		this.map = map;
	}
	
	public ArrayList<Vilain> getVilains()
	{
		return vilains;
	}
	
	public ArrayList<Artefact> getArtefact()
	{
		return artefacts;
	}
}
