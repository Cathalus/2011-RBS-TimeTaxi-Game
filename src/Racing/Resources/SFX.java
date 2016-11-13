package Racing.Resources;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class SFX {
	
	/* Sounds */
	public static Sound coin, fuel, crash,menueselect = null;
	/* Musik */
	public static Music bigblue, menue = null;
	
	public SFX() {
		try {
			crash = new Sound("res/sound/crash.wav");
			coin = new Sound("res/sound/chaching.wav");
			fuel = new Sound("res/sound/dingding.wav");
			menueselect = new Sound("res/sound/menueselect.wav");
			bigblue = new Music("res/music/menue.ogg");
			menue = new Music("res/music/menue.ogg");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
