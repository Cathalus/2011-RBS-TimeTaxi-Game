package Racing.States;

import java.awt.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Racing.Resources.Images;
import Racing.Utils.Globals;

public class EndGameState extends BasicGameState {
	
	int stateID = 0;
	private Input input;
	int counter = 0;
	
	Font font;
	TrueTypeFont truetypefont;

	public EndGameState(int ID)
	{
		this.stateID = ID;
	}
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		font = new Font("Verdana", Font.PLAIN, 25);
		truetypefont = new TrueTypeFont(font, true);
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		Globals.bg.DrawPauseScreen(g);
		truetypefont.drawString((Globals.WindowWidth/2)-100, Globals.WindowHeight/2, "Ein Spiel von");
		Images.logo_raymondwalter.draw((Globals.WindowWidth/2)-Images.logo_raymondwalter.getWidth()/2, Globals.WindowHeight/2+Images.logo_raymondwalter.getHeight()+15);
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		input = container.getInput();
		if(input.isKeyPressed(Input.KEY_ENTER) && input.isKeyPressed(Input.KEY_ESCAPE))
		{
			container.exit();
		}
		counter++;
	}

	public int getID() {
		return this.stateID;
	}

}
