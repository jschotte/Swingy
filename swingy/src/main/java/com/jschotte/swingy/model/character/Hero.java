package com.jschotte.swingy.model.character;

import com.jschotte.swingy.artefact.Armor;
import com.jschotte.swingy.artefact.Artefact;
import com.jschotte.swingy.artefact.Helm;
import com.jschotte.swingy.artefact.Weapon;
import com.jschotte.swingy.artefact.artefactFactory;
import com.jschotte.swingy.utils.customException;

public abstract class Hero
{
	private String name;
	private int level;
	private int exp;
	private int maxExp;
	
	protected int attack;
	private int defense;
	private int hp;
	
	private int maxHp;
	
	private int attackPerLevel;
	private int defensePerLevel;
	private int hpPerLevel;
	
	private Weapon weapon;
	private Armor armor;
	private Helm helm;
	
	public Hero(String name, int level, int exp, int hp, int baseattack, int basedefense, int basehp, int attackLevel, int defenseLevel, int hpLevel, String weapon, String armor, String helm)
	{
		if (level < 1 || exp < 0 || hp < 0)
			throw new customException("heroes data invalid");
		this.name = name;
		this.level = level;
		this.exp = exp;
		this.maxExp = this.level * 1000 + (this.level - 1) * (this.level - 1) * 450;
		
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
		
		this.weapon = artefactFactory.newWeaponArtefact(weapon);
		this.armor = artefactFactory.newArmorArtefact(armor);
		this.helm = artefactFactory.newHelmArtefact(helm);
	}
	
	public Hero(String name, int baseattack, int basedefense, int basehp, int attackLevel, int defenseLevel, int hpLevel)
	{
		this.name = name;
		this.level = 1;
		this.exp = 0;
		this.maxExp = this.level * 1000 + (this.level - 1) * (this.level - 1) * 450;

		this.attack = baseattack;
		this.defense = basedefense;
		this.maxHp = basehp;
		this.hp = this.maxHp;
		
		this.attackPerLevel = attackLevel;
		this.defensePerLevel = defenseLevel;
		this.hpPerLevel = hpLevel;
		
		this.weapon = null;
		this.armor = null;
		this.helm = null;
	}
	
	public void addExp(int exp)
	{
		this.exp += exp;
		if (this.exp >= this.maxExp)
		{
			this.level++;
			this.attack += this.attackPerLevel;
			this.defense += this.defensePerLevel;
			this.maxHp += this.hpPerLevel;
			
			this.hp = this.maxHp;
			this.exp = this.exp - this.maxExp;
			
			this.maxExp = this.level * 1000 + (this.level - 1) * (this.level - 1) * 450;

		}
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

	public Artefact getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Artefact getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public Artefact getHelm() {
		return helm;
	}

	public void setHelm(Helm helm) {
		this.helm = helm;
	}
	
	public String toString()
	{
		return this.name;
	}
}