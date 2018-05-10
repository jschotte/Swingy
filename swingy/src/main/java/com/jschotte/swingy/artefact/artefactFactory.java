package com.jschotte.swingy.artefact;


import com.jschotte.swingy.utils.customException;

public class artefactFactory
{
	static public Weapon newWeaponArtefact(String name)
	{
		if (name == null || name.equalsIgnoreCase("null"))
			return null;
		switch(name)
		{
			case "MasterSword":
				return new MasterSword();
			default:
				throw new customException("weapon unknown");
		}
	}
	
	static public Armor newArmorArtefact(String name)
	{
		if (name == null || name.equalsIgnoreCase("null"))
			return null;
		switch(name)
		{
			case "Maille":
				return new Maille();
			default:
				throw new customException("armor unknown");
		}
	}
	
	static public Helm newHelmArtefact(String name)
	{
		if (name == null || name.equalsIgnoreCase("null"))
			return null;
		switch(name)
		{
			case "IronHelm":
				return new IronHelm();
			default:
				throw new customException("helm unknown");
		}
	}
}
