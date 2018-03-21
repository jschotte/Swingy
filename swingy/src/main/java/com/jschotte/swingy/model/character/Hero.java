package com.jschotte.swingy.model.character;

import com.jschotte.swingy.utils.customException;

public abstract class Hero
{
	private String name;
	private int level;
	private int exp;
	
	protected int attack;
	private int defense;
	private int hp;
	
	private int maxHp;
	
	private int attackPerLevel;
	private int defensePerLevel;
	private int hpPerLevel;
	
	private String weapon;
	private String armor;
	private String helm;
	
	public Hero(String name, int level, int exp, int hp, int baseattack, int basedefense, int basehp, int attackLevel, int defenseLevel, int hpLevel)
	{
		if (level < 1 || exp < 0 || hp < 0)
			throw new customException("heroes data invalid");
		this.name = name;
		this.level = level;
		this.exp = exp;
		
		this.attack = baseattack;
		this.defense = basedefense;
		this.maxHp = basehp;
		
		this.attackPerLevel = attackLevel;
		this.defensePerLevel = defenseLevel;
		this.hpPerLevel = hpLevel;

		for (int i = 1; i < level; i++)
		{
			this.attack += this.attackPerLevel;
			this.defense += this.defensePerLevel;
			this.maxHp += this.hpPerLevel;
		}
		
		this.setHitPoints(hp);
		
		this.weapon = null;
		this.armor = null;
		this.helm = null;
	}
	
	public Hero(String name, int baseattack, int basedefense, int basehp, int attackLevel, int defenseLevel, int hpLevel)
	{
		this.name = name;
		this.level = 1;
		this.exp = 0;
		
		this.attack = baseattack;
		this.defense = basedefense;
		this.maxHp = basehp;
		this.hp = this.maxHp;
		
		this.attackPerLevel = attackLevel;
		this.defensePerLevel = defenseLevel;
		this.hpPerLevel = hpLevel;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getHitPoints() {
		return hp;
	}

	public void setHitPoints(int hitPoints)
	{
		if (hitPoints > this.maxHp)
			this.hp = this.maxHp;
		else
			this.hp = hitPoints;
	}

	public int getMaxHitPoints() {
		return maxHp;
	}

	public void setMaxHitPoints(int maxHitPoints) {
		this.maxHp = maxHitPoints;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public String getArmor() {
		return armor;
	}

	public void setArmor(String armor) {
		this.armor = armor;
	}

	public String getHelm() {
		return helm;
	}

	public void setHelm(String helm) {
		this.helm = helm;
	}
	
	public String toString()
	{
		return this.name;
	}
}