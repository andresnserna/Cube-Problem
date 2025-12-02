package model;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class CubeNetImpl_Skeleton implements CubeNet
{	
	private final Map<Face, Color> faceToColor;

	
	public CubeNetImpl_Skeleton(Color top, Color front, Color left, Color right, Color bottom, Color back)
	{
		faceToColor = new HashMap<>();
		faceToColor.put(Face.TOP, top);
		faceToColor.put(Face.LEFT, left);
		faceToColor.put(Face.FRONT, front);
		faceToColor.put(Face.RIGHT, right);
		faceToColor.put(Face.BOTTOM, bottom);
		faceToColor.put(Face.BACK, back);
	}
	
	public CubeNetImpl_Skeleton(Map<Face, Color> faceToColorMap)
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
		throw new RuntimeException("NOT IMPLEMENTED YET!");
	}
	
	//Improving on the inherited equals() is mandatory
	//to get improved performance
	//Also, whenever you change equals() you probably
	//need to change hashCode() to ensure that the "equals()/hashCode()
	//contract" is satisfied
	public boolean equals(Object obj)
	{
		throw new RuntimeException("NOT IMPLEMENTED YET!");
	}
	
	//Implement a decent toString() for yourself during development
	public String toString()
	{
		throw new RuntimeException("NOT IMPLEMENTED YET!");
	}
}
