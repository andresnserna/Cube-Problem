package model;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

public class CubeSolver_Skeleton
{
	private CubeSolver_Skeleton()
	{
		assert false : "DO NOT INSTANTIATE!";
	}
	
	public static Set<Cube> getDistinctSolidCubes(Set<Color> colors)
	{
		Set<CubeNet> allCubeNets = new HashSet<>();
	    
	    // Convert Set to array for indexed access
	    Color[] colorArray = colors.toArray(new Color[0]);
	    
	    // this big ol mess
	    for (Color top : colorArray) {
	        for (Color left : colorArray) {
	            for (Color front : colorArray) {
	                for (Color right : colorArray) {
	                    for (Color bottom : colorArray) {
	                        for (Color back : colorArray) {
	                            CubeNet cubeNet = new CubeNetImpl_Serna(top, front, left, right, bottom, back);
	                            allCubeNets.add(cubeNet);
	                        }
	                    }
	                }
	            }
	        }
	    }
	    
	    // TODO: Later, convert CubeNets to Cubes and return distinct cubes
	    // For now, just testing that we generate n^6 cube nets
	    System.out.println("Generated " + allCubeNets.size() + " cube nets");
	    
	    throw new RuntimeException("NOT FULLY IMPLEMENTED YET!");
	}
}
