package Racing.Controllers;

import org.newdawn.slick.Input;

public class KeyController {
	public String getKeyChar(Input input)
	{
		String result = "";
		if(input.isKeyPressed(Input.KEY_A))
		{
			result = "A";
		}else if(input.isKeyPressed(Input.KEY_B))
		{
			result = "B";
		}
		else if(input.isKeyPressed(Input.KEY_C))
		{
			result = "C";
		}
		else if(input.isKeyPressed(Input.KEY_D))
		{
			result = "D";
		}
		else if(input.isKeyPressed(Input.KEY_E))
		{
			result = "E";
		}
		else if(input.isKeyPressed(Input.KEY_F))
		{
			result = "F";
		}
		else if(input.isKeyPressed(Input.KEY_G))
		{
			result = "G";
		}
		else if(input.isKeyPressed(Input.KEY_H))
		{
			result = "H";
		}
		else if(input.isKeyPressed(Input.KEY_I))
		{
			result = "I";
		}
		else if(input.isKeyPressed(Input.KEY_J))
		{
			result = "J";
		}
		else if(input.isKeyPressed(Input.KEY_K))
		{
			result = "K";
		}
		else if(input.isKeyPressed(Input.KEY_L))
		{
			result = "L";
		}
		else if(input.isKeyPressed(Input.KEY_M))
		{
			result = "M";
		}
		else if(input.isKeyPressed(Input.KEY_N))
		{
			result = "N";
		}
		else if(input.isKeyPressed(Input.KEY_O))
		{
			result = "O";
		}
		else if(input.isKeyPressed(Input.KEY_P))
		{
			result = "P";
		}
		else if(input.isKeyPressed(Input.KEY_Q))
		{
			result = "Q";
		}
		else if(input.isKeyPressed(Input.KEY_R))
		{
			result = "R";
		}
		else if(input.isKeyPressed(Input.KEY_S))
		{
			result = "S";
		}
		else if(input.isKeyPressed(Input.KEY_T))
		{
			result = "T";
		}
		else if(input.isKeyPressed(Input.KEY_U))
		{
			result = "U";
		}
		else if(input.isKeyPressed(Input.KEY_V))
		{
			result = "V";
		}
		else if(input.isKeyPressed(Input.KEY_W))
		{
			result = "W";
		}
		else if(input.isKeyPressed(Input.KEY_X))
		{
			result = "X";
		}
		else if(input.isKeyPressed(Input.KEY_Y))
		{
			result = "Y";
		}
		else if(input.isKeyPressed(Input.KEY_Z))
		{
			result = "Z";
		}
		else if(input.isKeyPressed(Input.KEY_BACK))
		{
			result = "#";
		}
		return result;
	}
	
}
