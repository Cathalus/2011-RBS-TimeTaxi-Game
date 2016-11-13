package Racing.Entities;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

import Racing.Resources.Images;
import Racing.Utils.Globals;

public class HUD {

	TrueTypeFont truetypefont = null;
	Font font;
	
	public HUD()
	{
		font = new Font("Verdana", Font.BOLD, 20);
		truetypefont = new TrueTypeFont(font, true);
	}
	
	public void Draw(Graphics g)
	{
		int fueldeficit = 100-Globals.fuel;
		g.setColor(Color.black);
		g.fillRect(0, 0, 240, 30);
		g.fillRect(0, 30, 240, 30);
		Images.bar_fuelbar.draw(0,60);
		g.fillRect((float)(240-(fueldeficit*2.4)), 60,(float)(fueldeficit*2.4), 30);
		
		g.setColor(Color.white);
		g.drawRect(-1, -1, 240, 31);
		g.drawRect(-1, 29, 240, 31);
		g.drawRect(-1, 59, 240, 31);
		truetypefont.drawString(10, 2, "Score: " + Globals.score);
		truetypefont.drawString(10, 32, "Lives: ");
		truetypefont.drawString(98, 62, "Fuel");
		for(int i = 0; i < Globals.lives; i++)
		{
			Images.icon_car.draw(80+(i*30), 35);
		}		
	}
}
