package Racing.Utils;

import Racing.Entities.Background;
import Racing.Resources.Images;
import Racing.Resources.SFX;

public class Globals {
	public static Boolean started = false;
    public static Boolean paused = false;
    public static Boolean newgame = false;
    public static int difficulty = 0;
    public static int gameoverscore = 0;
    public static int WindowWidth, WindowHeight;
    public static int lives = 0;
    public static int fuel = 0;
    public static int score = 0;
    public static double speedfactor = 0.65;
    
    public static SFX sfx = new SFX();
    public static Background bg = new Background();
    public static Images images = new Images();
}
