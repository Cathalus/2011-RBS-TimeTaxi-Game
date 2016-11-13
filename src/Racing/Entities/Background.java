package Racing.Entities;

import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import Racing.Resources.Images;
import Racing.Utils.Globals;

public class Background {
	
	int PosX, PosY, PosYspace, PosYearth, onscreen, stripelength = 0;
	
	public Background()
	{		
		stripelength = 40;		
	}
	public void Move(int delta)
	{
		if(PosYspace>=0)
		{
			PosYspace = -Images.bg_space.getHeight();
		}
		if(PosY>=0)
		{
			PosY = -240;
		}
		PosY+=delta*1.5;
		PosYspace+=0.5*delta;
		PosYearth+=delta;
	}
	
	public void Draw(Graphics g) 
	{
		//g.texture(new Rectangle(0,0,Globals.WindowWidth,Globals.WindowHeight), space);
		for(int i = 0; i < 1+Math.round(Globals.WindowWidth/Images.bg_space.getWidth()); i++)
		{
			for(int j = 0; j < 2+Math.round(Globals.WindowHeight/Images.bg_space.getHeight()); j++)
			{
				Images.bg_space.draw(i*Images.bg_space.getWidth(), PosYspace+(j*Images.bg_space.getHeight()));
			}
		}
		//earth.draw(0-earth.getWidth()/2,PosYearth+Globals.WindowHeight-earth.getHeight()/2);
		Images.bg_street.draw((Globals.WindowWidth/2)-Images.bg_street.getWidth()/2, PosY);
	}
	
	public void DrawPauseScreen(Graphics g)
	{
		for(int i = 0; i < 1+Math.round(Globals.WindowWidth/Images.bg_space.getWidth()); i++)
		{
			for(int j = 0; j < 2+Math.round(Globals.WindowHeight/Images.bg_space.getHeight()); j++)
			{
				Images.bg_space.draw(i*Images.bg_space.getWidth(), PosYspace+(j*Images.bg_space.getHeight()));
			}
		}
		//street.draw((Globals.WindowWidth/2)-this.street.getWidth()/2, PosY);
		Images.menue_earth.draw(0-Images.menue_earth.getWidth()/2,Globals.WindowHeight-Images.menue_earth.getHeight()/2);
		Images.logo_timetaxi.draw((Globals.WindowWidth/2-Images.logo_timetaxi.getWidth()/2),((Globals.WindowWidth/2)/3-(Images.logo_timetaxi.getHeight()/2)));
		
	}
}