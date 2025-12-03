package model;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class CubeNetImpl_Serna implements CubeNet
{	
	private final Map<Face, Color> faceToColor;

	
	public CubeNetImpl_Serna(Color top, Color front, Color left, Color right, Color bottom, Color back)
	{
		faceToColor = new HashMap<>();
		faceToColor.put(Face.TOP, top);
		faceToColor.put(Face.LEFT, left);
		faceToColor.put(Face.FRONT, front);
		faceToColor.put(Face.RIGHT, right);
		faceToColor.put(Face.BOTTOM, bottom);
		faceToColor.put(Face.BACK, back);
	}
	
	public CubeNetImpl_Serna(Map<Face, Color> faceToColorMap)
	{
		faceToColor = faceToColorMap;
	}
	
	@Override
	public Color getColor(Face face)
	{
		return faceToColor.get(face);
	}

	//Improving on the inherited hashCode() is mandatory
	//to get improved performance
	//Also, whenever you change hashCode() you probably
	//need to change equals() to ensure that the "equals()/hashCode()
	//contract" is satisfied
	public int hashCode()
	{
		
		int result = 13; //taylor's favorite number
		int offset = 27; //my favorite number
		
		result = offset * result + colorCode(faceToColor.get(Face.TOP));
	    result = offset * result + colorCode(faceToColor.get(Face.LEFT));
	    result = offset * result + colorCode(faceToColor.get(Face.FRONT));
	    result = offset * result + colorCode(faceToColor.get(Face.RIGHT));
	    result = offset * result + colorCode(faceToColor.get(Face.BOTTOM));
	    result = offset * result + colorCode(faceToColor.get(Face.BACK));
	    
	    return result;
	}
	
	//Improving on the inherited equals() is mandatory
	//to get improved performance
	//Also, whenever you change equals() you probably
	//need to change hashCode() to ensure that the "equals()/hashCode()
	//contract" is satisfied
	public boolean equals(Object obj)
	{
		// Check if null
	    if (obj == null) {
	        return false;
	    }
	    
	    // Check if same instance
	    if (this == obj) {
	        return true;
	    }
	    
	    // Check if same type
	    if (!(obj instanceof CubeNet)) {
	        return false;
	    }
	    
	    // Cast and compare face by face
	    CubeNet other = (CubeNet) obj;
	    
	    return this.getColor(Face.TOP).equals(other.getColor(Face.TOP)) &&
	           this.getColor(Face.LEFT).equals(other.getColor(Face.LEFT)) &&
	           this.getColor(Face.FRONT).equals(other.getColor(Face.FRONT)) &&
	           this.getColor(Face.RIGHT).equals(other.getColor(Face.RIGHT)) &&
	           this.getColor(Face.BOTTOM).equals(other.getColor(Face.BOTTOM)) &&
	           this.getColor(Face.BACK).equals(other.getColor(Face.BACK));
	}
	
	//Implement a decent toString() for yourself during development
	public String toString()
	{
	    return CubeNetRendererImpl_Serna.CUBENET_UNICODE_SQUARE_RENDERER.getRendering(this);
	}
	
	private int colorCode(Color color)
	{
	    if (color == null) return 0;
	    if (color.equals(Color.RED)) return 1;
	    if (color.equals(Color.GREEN)) return 2;
	    if (color.equals(Color.BLUE)) return 3;
	    if (color.equals(Color.YELLOW)) return 4;
	    if (color.equals(Color.ORANGE)) return 5;
	    if (color.equals(Color.BLACK)) return 6;
	    if (color.equals(Color.WHITE)) return 7;
	    return 0; // fallback for unsupported colors
	}
	
	public Color getTop() {
	    return faceToColor.get(Face.TOP);
	}

	public Color getFront() {
	    return faceToColor.get(Face.FRONT);
	}

	public Color getRight() {
	    return faceToColor.get(Face.RIGHT);
	}

	public Color getBack() {
	    return faceToColor.get(Face.BACK);
	}

	public Color getLeft() {
	    return faceToColor.get(Face.LEFT);
	}

	public Color getBottom() {
	    return faceToColor.get(Face.BOTTOM);
	}
}
