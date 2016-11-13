package Racing.States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Racing.RacingGame;
import Racing.Resources.Images;
import Racing.Resources.SFX;
import Racing.Utils.Constants;
import Racing.Utils.Globals;

public class MainMenuState extends BasicGameState {
	int stateID = 0;
	private Input input;
	public Boolean runninggame = false;
	
	public MainMenuState(int state) {
		this.stateID = state;
	}
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		Globals.paused = true;
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		Globals.bg.DrawPauseScreen(g);
		if(Globals.started)
		{
			Images.btn_resume.draw((Globals.WindowWidth/2)-(Images.btn_newgame.getWidth()/2),((Globals.WindowHeight/2)-(Images.btn_newgame.getHeight()/2))-(Images.btn_newgame.getHeight()+10));
		}
		Images.btn_newgame.draw((Globals.WindowWidth/2)-(Images.btn_newgame.getWidth()/2),(Globals.WindowHeight/2)-(Images.btn_newgame.getHeight()/2));
		Images.btn_highscore.draw((Globals.WindowWidth/2)-(Images.btn_newgame.getWidth()/2),((Globals.WindowHeight/2)-(Images.btn_newgame.getHeight()/2))+(Images.btn_newgame.getHeight()+10));
		Images.btn_endgame.draw((Globals.WindowWidth/2)-(Images.btn_newgame.getWidth()/2),((Globals.WindowHeight/2)-(Images.btn_newgame.getHeight()/2))+2*(Images.btn_newgame.getHeight()+10));
	}

	public void getMouseOverButton(StateBasedGame game)
	{
		int widthbutton = ((Globals.WindowWidth/2)-(Images.btn_newgame.getWidth()/2));
		int heightbutton = ((Globals.WindowHeight/2)-(Images.btn_newgame.getHeight()/2));
		
		/* Resume */
		if(input.getMouseX() >= widthbutton && input.getMouseX() <= widthbutton+Images.btn_newgame.getWidth() &&
		   input.getMouseY() >= (heightbutton-(Images.btn_newgame.getHeight()+10)) && input.getMouseY() <= (heightbutton+Images.btn_newgame.getHeight()-(Images.btn_newgame.getHeight()+10)))
		{
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON) && Globals.paused)
			{
				SFX.menueselect.play();
				Globals.paused = false;
				SFX.menue.pause();
				SFX.bigblue.resume();
				game.enterState(Constants.GameplayState);
			}
		}
		
		
		/* New Game */
		if(input.getMouseX() >= widthbutton && input.getMouseX() <= widthbutton+Images.btn_newgame.getWidth() &&
		   input.getMouseY() >= heightbutton && input.getMouseY() <= heightbutton+Images.btn_newgame.getHeight())
		{
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
			{
				SFX.menueselect.play();
				game.enterState(Constants.SelectDifficultyState);
			}
		}
		
		/* Highscore */
		if(input.getMouseX() >= widthbutton && input.getMouseX() <= widthbutton+Images.btn_newgame.getWidth() &&
		   input.getMouseY() >= (heightbutton+(Images.btn_newgame.getHeight()+10)) && input.getMouseY() <= (heightbutton+Images.btn_newgame.getHeight()+(Images.btn_newgame.getHeight()+10)))
		{
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
			{
				SFX.menueselect.play();
				game.enterState(Constants.ShowHighscoreState);
			}
		}
		
		/* EndGame */
		if(input.getMouseX() >= widthbutton && input.getMouseX() <= widthbutton+Images.btn_newgame.getWidth() &&
		   input.getMouseY() >= (heightbutton+2*(Images.btn_newgame.getHeight()+10)) && input.getMouseY() <= (heightbutton+Images.btn_newgame.getHeight()+2*(Images.btn_newgame.getHeight()+10)))
		{
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
			{
				SFX.menueselect.play();
				game.enterState(Constants.EndGameState);
			}
		}
		
		
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		input = container.getInput();
		if(input.isKeyPressed(Input.KEY_ESCAPE) && Globals.started)
		{
			Globals.paused = false;
			SFX.menueselect.play();
			SFX.menue.pause();
			SFX.bigblue.resume();
			game.enterState(Constants.GameplayState);
		}
		this.getMouseOverButton(game);
	
		
	}

	public int getID() {
		return 0;
	}

}
