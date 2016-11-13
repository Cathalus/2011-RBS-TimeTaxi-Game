package Racing.States;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Racing.RacingGame;
import Racing.Entities.Car;
import Racing.Entities.Collectable;
import Racing.Entities.HUD;
import Racing.Entities.MovableObjects;
import Racing.Resources.SFX;
import Racing.Utils.Constants;
import Racing.Utils.Globals;

public class GameplayState extends BasicGameState {

	public int stateID = 1;
	public int updates = 0;
	private int additionalCars = 0;
	private ArrayList<MovableObjects> movables;
	private Input input;
	private Boolean crashed = false;
	private HUD hud;
	
	public GameplayState(int state) {
		this.stateID = state;
	}

	public void collisionDetection()
	{
		for(MovableObjects mo : movables)
		{
			if(mo.isplayer)
			{
				for(MovableObjects mov : movables)
				{
					if(mo.rect.intersects(mov.rect) && mo.rect != mov.rect)
					{
						if(mov instanceof Collectable)
						{
							switch(((Collectable) mov).getType())
							{
								case 0:
									SFX.coin.play();
									Globals.score += 500;
									break;
								case 1:
									SFX.fuel.play();
									Globals.fuel += 10;
									if(Globals.fuel > 100)
									{
										Globals.fuel = 100;
									}
									break;								
							}
						}else{
							SFX.crash.play();
							Globals.lives--;
							Globals.fuel = 100;
							this.crashed = true;
						}
						
					}
				}
			}else{
				for(MovableObjects mov : movables)
				{
					if(mo.rect.intersects(mov.rect) && mo.rect != mov.rect)
					{
						mo.setRandomLane();
					}
				}
			}
		}	
	}
	
	public void objectMovement(GameContainer container, int delta)
	{
		for(MovableObjects mo : movables)
		{
			if(mo.isplayer)
			{
				input = container.getInput();
				if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT))
		        {
					mo.playerdirection = 0;
		            mo.Move(delta);
		        }
		 
				if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT))
		        {
					mo.playerdirection = 1;
					mo.Move(delta);
		        }
			}else{
				mo.Move(delta);
			}
		}
		Globals.bg.Move(delta);
	}
	
	public void newCars()
	{
		movables = new ArrayList();
		movables.add(new Car(true));
		for(int i = 0; i < 7+Globals.difficulty; i++)
		{
			movables.add(new Car(false));
		}
		movables.add(new Collectable());
	}

	public int getID() {
		return this.stateID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException 
	{
		this.hud = new HUD();
		/* Wenn Spiel noch nicht gestartet */
		if(Globals.newgame)
		{
			SFX.bigblue.loop();
			Globals.lives = 3;
			Globals.fuel = 100;
			Globals.score = 0;
			Globals.newgame = false;
		}
		this.newCars();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
	{
		Globals.bg.Draw(g);
		for(MovableObjects mo : movables)
		{
			mo.Draw(g);
		}
		g.setColor(Color.white);
		hud.Draw(g);
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException 
	{		
		if(Globals.newgame)
		{
			this.init(container, game);
		}
		input = container.getInput();

		if(input.isKeyPressed(Input.KEY_ESCAPE))
		{
			if(Globals.lives <= 0)
			{
				Globals.started = false;
			}
			Globals.paused = true;
			SFX.bigblue.pause();
			SFX.menue.resume();
			game.enterState(Constants.MainMenuState);
		}
		if(Globals.lives > 0)
		{
			Globals.score+=1+Globals.difficulty;
			updates++;
			if(this.updates % 50 == 0)
			{
				Globals.fuel -= 1;
				this.updates = 0;
				if(Globals.fuel == 0)
				{
					Globals.lives--;
				}
			}
			if(this.crashed)
			{
				this.init(container, game);
				this.crashed = false;
			}else{
				objectMovement(container,delta);
				collisionDetection();
			}
		}else{
			SFX.bigblue.stop();
			Globals.gameoverscore = Globals.score;
			Globals.paused = true;
			Globals.started = false;
			Globals.newgame = true;
			game.enterState(Constants.EnterHighscoreState);
		}
	}
}
