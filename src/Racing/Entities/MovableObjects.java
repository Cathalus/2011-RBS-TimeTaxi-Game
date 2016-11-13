package Racing.Entities;

import java.awt.Graphics2D;
import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public abstract class MovableObjects {
	
	public float PosX, PosY = 0;
	public Rectangle rect = null;
	public Boolean isplayer = false;
	public int lane, playerdirection = 0;
	protected Random rng;
	protected float objectdisplacement = 0;
	public int coltype = 0;
	
	public abstract void Move(int delta);
	public abstract void Draw(Graphics g);
	
	public void setRandomLane()
	{
		this.lane = this.rng.nextInt(4);
		this.coltype = this.rng.nextInt(2);
		this.objectdisplacement = rng.nextInt(25);
		if(this.rng.nextInt(2) == 1)
		{
			this.objectdisplacement = 0-this.objectdisplacement;
		}
		this.PosY = -240-this.rng.nextInt(650);
	}
	
}
