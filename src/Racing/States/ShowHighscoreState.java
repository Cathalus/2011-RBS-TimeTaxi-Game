package Racing.States;

import java.awt.Font;
import java.sql.SQLException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Racing.RacingGame;
import Racing.Controllers.HighscoreController;
import Racing.Resources.Images;
import Racing.Utils.Constants;
import Racing.Utils.Globals;


public class ShowHighscoreState extends BasicGameState {

	public int stateID = 0;
	private HighscoreController highscore;
	private Font font_headline,font_lines;
	private TrueTypeFont headline,lines = null;
	private String[][] scores;
	private Input input;
	
	public ShowHighscoreState(int state)
	{
		this.stateID = state;
	}
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		try {
			highscore = new HighscoreController();
		} catch (Exception e) {
			e.printStackTrace();
		}
		font_headline = new Font("Verdana", Font.BOLD, 25);
		headline = new TrueTypeFont(font_headline, true);
		font_lines = new Font("Verdana", Font.PLAIN, 20);
		lines = new TrueTypeFont(font_lines,true);
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		Globals.bg.DrawPauseScreen(g);
		headline.drawString(Globals.WindowWidth/2-300, Globals.WindowHeight/2-150, "Top 10");
		
		int datacounter = 0;
		int number = 1;
		for(String[] i : scores)
		{
			for(String j : i)
			{
				if(j != null)
				{
					datacounter++;
					switch(datacounter)
					{
						case 1:
							lines.drawString(Globals.WindowWidth/2-280, (Globals.WindowHeight/2-(120))+(number*20), number+". "+j);
							break;
						case 2:
							lines.drawString(Globals.WindowWidth/2-280+(500), (Globals.WindowHeight/2-(120))+(number*20), j);
							datacounter = 0;
							break;
					}
				}
			}
			number++;
		}
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		input = container.getInput();
		if(input.isKeyPressed(Input.KEY_ESCAPE) || input.isKeyPressed(Input.KEY_ENTER))
		{
			game.enterState(Constants.MainMenuState);
		}
		try {
			scores = highscore.getTopTen();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getID() {
		return this.stateID;
	}

}
