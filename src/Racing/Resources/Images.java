package Racing.Resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Images {
	
	/* Cars */
	public static Image car_blue, car_gray, car_green, car_orange, car_purple, car_red, car_white, car_player;
	
	/* Collectables */ 
	public static Image coll_fuel, coll_coin;
	
	/* Buttons */
	public static Image  btn_savescore,btn_newgame,btn_resume,btn_highscore,btn_endgame,btn_easy,btn_medium,btn_hard;
	
	/* Logos */
	public static Image logo_raymondwalter, logo_timetaxi;
	
	/* Icons */
	public static Image icon_car;
	
	/* Bars */
	public static Image bar_fuelbar;
	
	/* Menue */
	public static Image menue_earth;
	
	/* Background */
	public static Image bg_space, bg_street;
	
	public Images()
	{
		try {
			car_player 			= new Image("res/cars/player_space.png");
			car_blue 			= new Image("res/cars/blue_space.png");
			car_gray 			= new Image("res/cars/gray_space.png");
			car_green 			= new Image("res/cars/green_space.png");
			car_orange 			= new Image("res/cars/orange_space.png");
			car_purple 			= new Image("res/cars/purple_space.png");
			car_red 			= new Image("res/cars/red_space.png");
			car_white 			= new Image("res/cars/white_space.png");
			
			coll_fuel 			= new Image("res/collectables/fuel_plutonium.png");
			coll_coin 			= new Image("res/collectables/coin.png");
			
			btn_savescore		= new Image("res/buttons/save_score.png");
			btn_newgame 		= new Image("res/buttons/new_game.png");
			btn_resume 			= new Image("res/buttons/resume.png");
			btn_highscore 		= new Image("res/buttons/highscore.png");
			btn_endgame 		= new Image("res/buttons/end_game.png");
			btn_easy 			= new Image("res/buttons/easy.png");
			btn_medium 			= new Image("res/buttons/medium.png");
			btn_hard 			= new Image("res/buttons/hard.png");
			
			logo_raymondwalter	= new Image("res/logos/raymondwalter.png");
			logo_timetaxi		= new Image("res/logos/timetaxi.png");
			
			icon_car 			= new Image("res/icons/icon_car.png");
			
			bar_fuelbar 		= new Image("res/bars/fuelbar.png");
			
			menue_earth 		= new Image("res/earth.png");
			
			bg_street 			= new Image("res/textures/street_space.png");
			bg_space 			= new Image("res/textures/space.jpg");
			
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
}
