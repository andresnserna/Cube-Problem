package model;

import java.awt.Color;
import java.util.Set;
import static model.UnicodeUtils_Kart.*;


public enum ColorRendererImpl_Serna implements ColorRenderer_Kart
{
	UNICODE_SQUARE_RENDERER;
	
	@Override
	public Set<Color> getSupportedColors()
	{
	    Set<Color> supportedColors = Set.of(
	            Color.RED,
	            Color.GREEN,
	            Color.BLUE,
	            Color.YELLOW,
	            Color.ORANGE,
	            Color.BLACK,
	            Color.WHITE
	    );

	    assert supportedColors.equals(Set.of(
	            Color.RED,
	            Color.GREEN,
	            Color.BLUE,
	            Color.YELLOW,
	            Color.ORANGE,
	            Color.BLACK,
	            Color.WHITE
	    )) : "Supported Colors not implemented correctly";

	    return supportedColors;
	}

	
	@Override
	public String getRendering(Color color)
	{
	// preconditions
		assert getSupportedColors().contains(color) : "Color: " + color + " is not supported";	
	// end of preconditions
	
		
	// implementation
		if (Color.RED.equals(color))      return LARGE_RED_SQUARE;
	    if (Color.ORANGE.equals(color))   return LARGE_ORANGE_SQUARE;
	    if (Color.YELLOW.equals(color))   return LARGE_YELLOW_SQUARE;
	    if (Color.GREEN.equals(color))    return LARGE_GREEN_SQUARE;
	    if (Color.BLUE.equals(color))     return LARGE_BLUE_SQUARE;
	    if (Color.BLACK.equals(color))    return LARGE_BLACK_SQUARE;
	    if (Color.WHITE.equals(color))    return LARGE_WHITE_SQUARE;
	    
	    //incase of unsupported rendering, but shouldn't be possible to reach this because of pre
	    return "?";
	// end of implementation
	
	// postconditions
//		assert RED_SQUARE.equals(getRendering(Color.RED))
	// end of postconditions
		
	}
}