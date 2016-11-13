package Racing.States;

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

public class SelectDifficultyState extends BasicGameState {

	int stateID = 0;
	
	private Input input;
	
	public SelectDifficultyState(int state) {
		this.stateID = state;
	}
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
	}
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		Globals.bg.DrawPauseScreen(g);
		Images.btn_easy.draw((Globals.WindowWidth/2)-(Images.btn_easy.getWidth()/2),(Globals.WindowHeight/2)-(Images.btn_easy.getHeight()/2));
		Images.btn_medium.draw((Globals.WindowWidth/2)-(Images.btn_easy.getWidth()/2),((Globals.WindowHeight/2)-(Images.btn_easy.getHeight()/2))+(Images.btn_easy.getHeight()+10));
		Images.btn_hard.draw((Globals.WindowWidth/2)-(Images.btn_easy.getWidth()/2),((Globals.WindowHeight/2)-(Images.btn_easy.getHeight()/2))+2*(Images.btn_easy.getHeight()+10));
	}
	
	public void getMouseOverButton(StateBasedGame game)
	{
		int widthbutton = ((Globals.WindowWidth/2)-(Images.btn_easy.getWidth()/2));
		int heightbutton = ((Globals.WindowHeight/2)-(Images.btn_easy.getHeight()/2));

		/* Easy */
		if(input.getMouseX() >= widthbutton && input.getMouseX() <= widthbutton+Images.btn_easy.getWidth() &&
		   input.getMouseY() >= heightbutton && input.getMouseY() <= heightbutton+Images.btn_easy.getHeight())
		{
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
			{
				SFX.menueselect.play();
				Globals.difficulty = 0;
				SFX.menue.pause();
				this.startGame(game);
			}
		}
		
		/* Medium */
		if(input.getMouseX() >= widthbutton && input.getMouseX() <= widthbutton+Images.btn_easy.getWidth() &&
		   input.getMouseY() >= (heightbutton+(Images.btn_easy.getHeight()+10)) && input.getMouseY() <= (heightbutton+Images.btn_easy.getHeight()+(Images.btn_easy.getHeight()+10)))
		{
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
			{
				SFX.menueselect.play();
				Globals.difficulty = 1;
				game.enterState(Constants.GameplayState);
				SFX.menue.pause();
				this.startGame(game);
			}
		}
		
		/* Hard */
		if(input.getMouseX() >= widthbutton && input.getMouseX() <= widthbutton+Images.btn_easy.getWidth() &&
		   input.getMouseY() >= (heightbutton+2*(Images.btn_easy.getHeight()+10)) && input.getMouseY() <= (heightbutton+Images.btn_easy.getHeight()+2*(Images.btn_easy.getHeight()+10)))
		{
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
			{
				SFX.menueselect.play();
				Globals.difficulty = 2;
				SFX.menue.pause();
				this.startGame(game);
			}
		}
	}
	
	public void startGame(StateBasedGame game)
	{
		Globals.paused = false;
		Globals.started = true;
		Globals.newgame = true;
		game.enterState(Constants.GameplayState);
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		input = container.getInput();
		this.getMouseOverButton(game);
	}
	public int getID() {
		return this.stateID;
	}

}
