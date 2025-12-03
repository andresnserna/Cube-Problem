package model;

import java.awt.Color;
import java.util.Set;

import static java.awt.Color.*;
import static model.UnicodeUtils.*;

public interface ColorRenderer
{
	/**
	 * @author kart
	 *
	 */
	
	//part of post:
	//rv.equals({RED, GREEN, BLUE, YELLOW, ORANGE,
	//BLACK, WHITE})
	public Set<Color> getSupportedColors();
	
	//part of pre: getSupportedColors.contains(color)
	//part of post: RED_SQUARE.equals(getRendering(Color.RED))
	//Analogous postconditions for the colors GREEN, BLUE, YELLOW,
	//ORANGE, BLACK, and WHITE
	public String getRendering(Color color);
}
