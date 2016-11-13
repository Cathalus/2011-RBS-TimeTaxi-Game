package Racing.Entities;

import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import Racing.RacingGame;
import Racing.Resources.Images;
import Racing.Utils.Globals;

public class Car extends MovableObjects {

	private int cartype = 0;
	
	public Car(Boolean isplayer)
	{
		this.rng = new Random();
		this.isplayer = isplayer;
		this.cartype = this.rng.nextInt(7);
		this.setRandomLane();

		if(this.isplayer)
		{
			PosX = (Globals.WindowWidth/2)-200;
			PosY = Globals.WindowHeight - 150;
		}
		this.rect = new Rectangle(this.PosX, this.PosY,Images.car_player.getWidth(),Images.car_player.getHeight());
	}
	
	public void Move(int delta) {
		this.rect = new Rectangle(this.PosX, this.PosY,Images.car_player.getWidth(),Images.car_player.getHeight());
		if(PosY > Globals.WindowHeight)
		{
			this.setRandomLane();
			this.cartype = this.rng.nextInt(7);
		}
		
		if(!isplayer)
		{
			switch(lane)
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
		}else{
			switch(this.playerdirection)
			{
				case 0:
					if(PosX >= (Globals.WindowWidth/2-394))
					{
						this.PosX -= delta*Globals.speedfactor;
					}
					break;
				case 1:
					if(PosX <= (Globals.WindowWidth/2+394)-Images.car_player.getWidth())
					{
						this.PosX += delta*Globals.speedfactor;
					}
					break;
			}
		}
	}

	public void Draw(Graphics g) {
		if(!isplayer)
		{
			switch(cartype)
			{
				case 0:
					Images.car_blue.draw(this.PosX, this.PosY);
					break;
				case 1:
					Images.car_gray.draw(this.PosX, this.PosY);
					break;
				case 2:
					Images.car_green.draw(this.PosX, this.PosY);
					break;
				case 3:
					Images.car_orange.draw(this.PosX, this.PosY);
					break;
				case 4:
					Images.car_purple.draw(this.PosX, this.PosY);
					break;
				case 5:
					Images.car_red.draw(this.PosX, this.PosY);
					break;
				case 6:
					Images.car_white.draw(this.PosX, this.PosY);
					break;
			}
		}else{
			Images.car_player.draw(this.PosX,(Globals.WindowHeight-150));
		}
	}

}
