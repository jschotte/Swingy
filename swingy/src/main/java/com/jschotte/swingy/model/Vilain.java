package com.jschotte.swingy.model;

public class Vilain
{
	private int posX;
	private int posY;
	private int power;
	
	public Vilain(int x, int y)
	{
		this.setPosX(x);
		this.setPosY(y);
		this.setPower((int)(Math.random() * (9) + 1));
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
}
