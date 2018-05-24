package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet 
{
	
	private double x,y;
	
	private double velX;
	private double velY;
	
	BufferedImage image;
	
	public Bullet(double x, double y, Game game)
	{
		this.x = x;
		this.y = y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		
		image = ss.grabImage(2, 1, 32, 32);
	}
	
	public void tick()
	{ 
		 y -= 10;
	}
	
	public void render(Graphics g)
	{
		g.drawImage(image,  (int)x, (int)y, null);
	}
	
}
import java.awt.Graphics;
import java.util.LinkedList;

public class Controller 
{
	private LinkedList<Bullet> b = new LinkedList<Bullet>();
	
	Bullet TempBullet;
	
	Game game;
	
	public Controller(Game game)
	{
		this.game = game;
	}
	
	public void tick()
	{
		for(int i = 0; i < b.size(); i++)
		{
			TempBullet = b.get(i);
			
			TempBullet.tick();
		}
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < b.size(); i++)
		{
			TempBullet = b.get(i);
			
			TempBullet.render(g);
		}
	}
	
	public void addBullet(Bullet block)
	{
		b.add(block);
	}
	
	public void removeBullet(Bullet block)
	{
		b.remove(block);
	}
}
