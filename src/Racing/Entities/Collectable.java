package Racing.Entities;

import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import Racing.RacingGame;
import Racing.Resources.Images;
import Racing.Utils.Globals;

public class Collectable extends MovableObjects {
	
	public Collectable()
	{
		this.rng = new Random();
		this.lane = this.rng.nextInt(4);
		this.setRandomLane();

		this.rect = new Rectangle(this.PosX, this.PosY,Images.coll_coin.getWidth(),Images.coll_coin.getHeight());
	}
	
	public void Move(int delta) 
	{
		this.rect = new Rectangle(this.PosX, this.PosY,Images.coll_coin.getWidth(),Images.coll_coin.getHeight());
		if(PosY > Globals.WindowHeight)
		{
			this.setRandomLane();
			this.PosY -= delta*Globals.speedfactor*100-this.rng.nextInt(120);
		}else{
			switch(this.lane)
			{
				case 0:
					PosX = (Globals.WindowWidth/2)-375+this.objectdisplacement;
					PosY += delta*Globals.speedfactor+Globals.difficulty;
					break;
				case 1:
					PosX = (Globals.WindowWidth/2)-165+this.objectdisplacement;
					PosY += delta*Globals.speedfactor+Globals.difficulty;
					break;
				case 2:
					PosX = (Globals.WindowWidth/2)+35+this.objectdisplacement;
					PosY += delta*Globals.speedfactor+Globals.difficulty;
					break;
				case 3:
					PosX = (Globals.WindowWidth/2)+235+this.objectdisplacement;
					PosY += delta*Globals.speedfactor+Globals.difficulty;
					break;
			}
		}
	}

	public void Draw(Graphics g) 
	{
		switch(this.coltype)
		{
			case 0:
				Images.coll_coin.draw(this.PosX, this.PosY);
				break;
			case 1:
				Images.coll_fuel.draw(this.PosX, this.PosY);
				break;
		}
	}
	
	public int getType()
	{
		return this.coltype;
	}

}
