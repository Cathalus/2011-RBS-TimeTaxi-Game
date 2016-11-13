package Racing;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import Racing.Resources.Images;
import Racing.Resources.SFX;
import Racing.States.EndGameState;
import Racing.States.EnterHighscoreState;
import Racing.States.GameplayState;
import Racing.States.MainMenuState;
import Racing.States.SelectDifficultyState;
import Racing.States.ShowHighscoreState;

import Racing.Utils.Constants;
import Racing.Utils.Globals;

public class RacingGame extends StateBasedGame {

	private int WindowWidth, WindowHeight = 0;
	
	public RacingGame(String title, int width, int height) {
		super(title);
		this.WindowWidth = width;
		this.WindowHeight = height;
		/* Spielestates zu gamecontainer Statelist hinzufügen */
		this.addState(new MainMenuState(Constants.MainMenuState));
        this.addState(new GameplayState(Constants.GameplayState));
        this.addState(new SelectDifficultyState(Constants.SelectDifficultyState));
        this.addState(new EnterHighscoreState(Constants.EnterHighscoreState));
        this.addState(new ShowHighscoreState(Constants.ShowHighscoreState));
        this.addState(new EndGameState(Constants.EndGameState));
        this.enterState(Constants.MainMenuState);
	}
	
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		Globals.WindowWidth = this.WindowWidth;
		Globals.WindowHeight = this.WindowHeight;
		SFX.menue.loop();
		this.getState(Constants.MainMenuState).init(container, this);
		this.getState(Constants.GameplayState).init(container, this);
		this.getState(Constants.SelectDifficultyState).init(container, this);
		this.getState(Constants.EnterHighscoreState).init(container,this);
		this.getState(Constants.ShowHighscoreState).init(container,this);
		this.getState(Constants.EndGameState).init(container, this);
	}

	public static void main(String[] args) {
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int WindowWidth = windowSize.width;
		int WindowHeight = windowSize.height;
		
		RacingGame game = new RacingGame("Taxi Racer", WindowWidth, WindowHeight);
		try {
			AppGameContainer cont = new AppGameContainer(game);
			cont.setShowFPS(true);
			cont.setDisplayMode(WindowWidth, WindowHeight, true);
			cont.setVSync(true);
			cont.setClearEachFrame(true);
			cont.setTargetFrameRate(60);
			cont.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
