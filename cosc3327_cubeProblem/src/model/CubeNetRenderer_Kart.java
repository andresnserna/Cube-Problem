package model;

import java.awt.Color;
import java.util.Set;

public interface CubeNetRenderer_Kart
{
	/**
	 * @author kart
	 *
	 */
	
	//{RED, GREEN, BLUE, YELLOW, ORANGE, BLACK, WHITE}.equals(rv),
	//where RED is Color.RED, etc.
	public Set<Color> getSupportedColors();
	
	//part of pre: cubeNet != null
	//part of post:
	//  getRendering(new CubeNetImpl(Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW, Color.BLACK)) is:
	//	💿🟥💿️
	//	🟦🟩🟧
	//	💿️🟨💿️
	//	💿️⬛💿️
	//  where Top is Red, Left is Blue, Front is Green, Right is Orange, Bottom is Yellow, Back is Black
	//  and rv.size() == 12*2 + 3*1 = 39 in this case (note that there are 12 unicode squares and each square
	//  occupies 2 characters and there are 3 newline characters.
	public String getRendering(CubeNet cubeNet);
}
