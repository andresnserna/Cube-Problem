package model;

import java.awt.Color;
import java.util.Set;

public enum CubeNetRendererImpl_Serna implements CubeNetRenderer_Kart
{
	CUBENET_UNICODE_SQUARE_RENDERER;
	private final ColorRenderer_Kart myRenderer = ColorRendererImpl_Serna.UNICODE_SQUARE_RENDERER;
	
	public Set<Color> getSupportedColors()
	{
		return myRenderer.getSupportedColors();
	}
	
	//part of pre: cubeNet != null
	//part of post:
	//  getRendering(new CubeNetImpl(Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW, Color.BLACK)) is:
	//	💿🟥💿️
	//	🟦🟩🟧
	//	💿️🟨💿️
	//	💿️⬛💿️️
	//  where Top is Red, Left is Blue, Front is Green, Right is Orange, Bottom is Yellow, Back is Black
	//  and rv.size() == 12*2 + 3*1 = 39 in this case (note that there are 12 unicode squares and each square
	//  occupies 2 characters and there are 3 newline characters.
	public String getRendering(CubeNet cubeNet)
	{
		//precondition check
		assert cubeNet != null : "cubeNet is null!";
		
//		String top = myRenderer.getRendering(cubeNet.getColor(Face.TOP));
//		String left = myRenderer.getRendering(cubeNet.getColor(Face.LEFT));
//		String front = myRenderer.getRendering(cubeNet.getColor(Face.FRONT));
//		String right = myRenderer.getRendering(cubeNet.getColor(Face.RIGHT));
//		String bottom = myRenderer.getRendering(cubeNet.getColor(Face.BOTTOM));
//		String back = myRenderer.getRendering(cubeNet.getColor(Face.BACK));
		
		//this SHOULD be the job of the colorRenderer, but as an extra precaution, the "?" rendering can happen here too.
		String top = myRenderer.getSupportedColors().contains(cubeNet.getColor(Face.TOP)) ? myRenderer.getRendering(cubeNet.getColor(Face.TOP)) : "?";
		String left = myRenderer.getSupportedColors().contains(cubeNet.getColor(Face.LEFT)) ? myRenderer.getRendering(cubeNet.getColor(Face.LEFT)) : "?";
		String front = myRenderer.getSupportedColors().contains(cubeNet.getColor(Face.FRONT)) ? myRenderer.getRendering(cubeNet.getColor(Face.FRONT)) : "?";
		String right = myRenderer.getSupportedColors().contains(cubeNet.getColor(Face.RIGHT)) ? myRenderer.getRendering(cubeNet.getColor(Face.RIGHT)) : "?";
		String bottom = myRenderer.getSupportedColors().contains(cubeNet.getColor(Face.BOTTOM)) ? myRenderer.getRendering(cubeNet.getColor(Face.BOTTOM)) : "?";
		String back = myRenderer.getSupportedColors().contains(cubeNet.getColor(Face.BACK)) ? myRenderer.getRendering(cubeNet.getColor(Face.BACK)) : "?";
		String disk = UnicodeUtils_Kart.OPTICAL_DISK;

		StringBuilder sb = new StringBuilder();
		sb.append(disk + top + disk + "\n");
		sb.append(left + front + right + "\n");
		sb.append(disk + bottom + disk + "\n");
		sb.append(disk + back + disk);
		
		//postconditon check
		//assert sb.length() == 26 : "Rendering size incorrect: " + sb.length();
		return sb.toString();

	}
}
