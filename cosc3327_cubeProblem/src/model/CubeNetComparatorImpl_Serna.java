package model;

import java.awt.Color;
import java.util.Comparator;

public enum CubeNetComparatorImpl_Serna implements Comparator<CubeNet>
{
	TLFRBB_COLOR_COMPARATOR;
	
	private static final int FIRST_EQUALS_SECOND = 0;
	private static final int FIRST_LESS_THAN_SECOND = -1;
	private static final int FIRST_GREATER_THAN_SECOND = 1;
	
	@Override
	public int compare(CubeNet cubeNet1, CubeNet cubeNet2)
	{
		assert cubeNet1 != null : "cubeNet1 is null!";
		assert cubeNet2 != null : "cubeNet2 is null!";
		
		Color[] colors1 = getColors(cubeNet1);
		Color[] colors2 = getColors(cubeNet2);
		
		int[] colorsRGB1 = getColorsRGB(colors1);
		int[] colorsRGB2 = getColorsRGB(colors2);
		
		return compare(colorsRGB1, colorsRGB2);
	}
	
	private static Color[] getColors(CubeNet cubeNet)
	{
		//rv is [cubeNet.getColor(TOP), cubeNet.getColor(LEFT), cubeNet.getColor(FRONT), cubeNet.getColor(RIGHT), cubeNet.getColor(BOTTOM), cubeNet.getColor(BACK)]
		assert cubeNet != null : "cubeNet is null!";

	    return new Color[] {
	            cubeNet.getColor(Face.TOP),
	            cubeNet.getColor(Face.LEFT),
	            cubeNet.getColor(Face.FRONT),
	            cubeNet.getColor(Face.RIGHT),
	            cubeNet.getColor(Face.BOTTOM),
	            cubeNet.getColor(Face.BACK)
	    };
	}
	
	private static int[] getColorsRGB(Color[] colors)
	{
		//part of pre: colors != null
		//part of pre: colors[i] != null for all i in [0, colors.length())
		//part of post: rv[i].equals(colors[i].getRGB())
	    assert colors != null : "colors is null!";
	    
	    for (int i = 0; i < colors.length; i++) {
	        assert colors[i] != null : "colors[" + i + "] is null!";
	    }

	    System.out.println("colorsRGB = " + getRendering(colors, ColorRendererImpl_Serna.UNICODE_SQUARE_RENDERER) + "\n");

	    int[] rgbIntArray = new int[colors.length];
	    for (int i = 0; i < colors.length; i++) {
	    	rgbIntArray[i] = colors[i].getRGB(); // **remember, returns ARGB packed int
	    }

	    return rgbIntArray;
	}
	
	private static String getRendering(Color[] colors, ColorRenderer_Kart renderer)
	{
		//part of post: rv will look something like this:
		//🟥🟦🟩🟧🟨⬛
		assert colors != null : "colors is null!";
		assert renderer != null : "renderer is null!";
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < colors.length; i++) {
	        assert colors[i] != null : "colors[" + i + "] is null!";
	        sb.append(renderer.getRendering(colors[i]));
	    }
		
		return sb.toString();
	}
	
	private static int compare(int[] array1, int[] array2)
	{
		// preconditions
	    assert array1 != null : "array1 is null!";
	    assert array2 != null : "array2 is null!";
	    
		//I would normally make this method more general
		//but I think this more narrow precondition might
		//help students catch errors:
		assert array1.length == array2.length : "array1.length = " + array1.length + " <> " + array2.length + " = array2.length! : array1 = " + array1 + " array2 = " + array2;

	    final int COMMON_LENGTH = array1.length;
	    int i = 0;
	    boolean foundDisagreement = false;

	    while (i < COMMON_LENGTH && !foundDisagreement)
	    {
	        if (array1[i] < array2[i])
	        {
	            return FIRST_LESS_THAN_SECOND;
	        }
	        else if (array1[i] > array2[i])
	        {
	            return FIRST_GREATER_THAN_SECOND;
	        }
	        else
	        {
	            i++; // moving on...
	        }
	    }

	    // finished the whole loop with no disagreements! woo
	    return FIRST_EQUALS_SECOND;
	}
	
	private static String comparisonString(CubeNet cubeNet1, CubeNet cubeNet2)
	{
		//Example rv:
		//🟥🟦🟩🟧🟨⬛
		//LESS THAN
		//🟥🟩🟩🟩🟩🟩
		
		assert cubeNet1 != null : "cubeNet1 is null!";
	    assert cubeNet2 != null : "cubeNet2 is null!";

	    // Convert cubes into 1-line unicode strings
	    Color[] colors1 = getColors(cubeNet1);
	    Color[] colors2 = getColors(cubeNet2);

	    String line1 = getRendering(colors1, ColorRendererImpl_Serna.UNICODE_SQUARE_RENDERER);
	    String line2 = getRendering(colors2, ColorRendererImpl_Serna.UNICODE_SQUARE_RENDERER);

	    // Now compare directly using the comparator enum
	    int cmp = CubeNetComparatorImpl_Serna.TLFRBB_COLOR_COMPARATOR.compare(cubeNet1, cubeNet2);

	    String relation;
	    if (cmp < 0)      relation = "LESS THAN";
	    else if (cmp > 0) relation = "GREATER THAN";
	    else              relation = "EQUAL TO";

	    return line1 + "\n" + relation + "\n" + line2;
	}
}
