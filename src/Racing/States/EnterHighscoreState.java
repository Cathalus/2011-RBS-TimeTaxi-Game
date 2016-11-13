package Racing.States;
import java.awt.Font;
import java.sql.SQLException;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Racing.RacingGame;
import Racing.Controllers.HighscoreController;
import Racing.Controllers.KeyController;
import Racing.Resources.Images;
import Racing.Resources.SFX;
import Racing.Utils.Constants;
import Racing.Utils.Globals;

public class EnterHighscoreState extends BasicGameState {

	private int stateID = 0;
	private Input input;
	public Boolean runninggame = false;
	public String enteredname = "";
	private KeyController key = new KeyController();
	private Font font;
	private TrueTypeFont ttf = null;
	private HighscoreController highscore;
	
	public EnterHighscoreState(int state) {	
		this.stateID = state;
	}
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		try {
			highscore = new HighscoreController();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		font = new Font("Verdana", Font.BOLD, 20);
		ttf = new TrueTypeFont(font, true);
		Globals.paused = true;
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		
		Globals.bg.DrawPauseScreen(g);
		g.setColor(Color.black);
		g.fillRect((Globals.WindowWidth/2)-(Images.btn_savescore.getWidth()/2)-10, ((Globals.WindowHeight/2)-(Images.btn_savescore.getHeight()/2))-(Images.btn_savescore.getHeight())-10, Images.btn_savescore.getWidth()+20, 2*Images.btn_savescore.getHeight()+20);
		ttf.drawString((Globals.WindowWidth/2)-(Images.btn_savescore.getWidth()/2),((Globals.WindowHeight/2)-(Images.btn_savescore.getHeight()/2))-(Images.btn_savescore.getHeight()-20),"Score: "+Globals.gameoverscore);
		ttf.drawString((Globals.WindowWidth/2)-(Images.btn_savescore.getWidth()/2),((Globals.WindowHeight/2)-(Images.btn_savescore.getHeight()/2))-(Images.btn_savescore.getHeight()),"Name: "+enteredname);
		Images.btn_savescore.draw((Globals.WindowWidth/2)-(Images.btn_savescore.getWidth()/2),(Globals.WindowHeight/2)-(Images.btn_savescore.getHeight()/2));
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		input = container.getInput();
		String eingabe = key.getKeyChar(input);
		if(eingabe != "")
		{
			if(eingabe != "#")
			{
				enteredname += eingabe;
			}else{
				String enteredname_alt = enteredname;
				if(enteredname_alt.length()>=1)
				{
					enteredname = enteredname_alt.substring(0,enteredname_alt.length()-1);
				}
			}
		}
		input = container.getInput();
		if(input.isKeyPressed(Input.KEY_ENTER) && enteredname != "")
		{
			SFX.menueselect.play();
			this.saveHighscore();
			game.enterState(Constants.MainMenuState);
		}		
		this.getMouseOverButton(game);
	}

	public void getMouseOverButton(StateBasedGame game)
	{
		int widthbutton = ((Globals.WindowWidth/2)-(Images.btn_savescore.getWidth()/2));
		int heightbutton = ((Globals.WindowHeight/2)-(Images.btn_savescore.getHeight()/2));
		
		/* Save Highscore */
		if(input.getMouseX() >= widthbutton && input.getMouseX() <= widthbutton+Images.btn_savescore.getWidth() &&
		   input.getMouseY() >= heightbutton && input.getMouseY() <= heightbutton+Images.btn_savescore.getHeight())
		{
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON) && enteredname != "")
			{
				SFX.menueselect.play();
				this.saveHighscore();
				game.enterState(Constants.MainMenuState);
			}
		}
	}
	
	private void saveHighscore()
	{
		try {
			highscore.insertScore(enteredname, Globals.gameoverscore);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Globals.gameoverscore = 0;
	}
	
	public int getID() {
		return this.stateID;
	}

}
