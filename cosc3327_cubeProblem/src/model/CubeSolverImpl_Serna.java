package model;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

public class CubeSolverImpl_Serna
{
	private CubeSolverImpl_Serna()
	{
		assert false : "DO NOT INSTANTIATE!";
	}
	
	public static Set<Cube> getDistinctSolidCubes(Set<Color> colors)
	{
	    Set<Cube> distinctCubes = new HashSet<>(); 
	    
	    // making the set -> array for indice access
	    Color[] colorArray = colors.toArray(new Color[0]);
	    
	    // this big ol mess
	    for (Color top : colorArray) {
	        for (Color left : colorArray) {
	            for (Color front : colorArray) {
	                for (Color right : colorArray) {
	                    for (Color bottom : colorArray) {
	                        for (Color back : colorArray) {
	                            CubeNet cubeNet = new CubeNetImpl_Serna(top, front, left, right, bottom, back);
	                            // make a cube from this cubeNET
	                            Cube cube = new CubeImpl_Serna(cubeNet);
	                            // add the cube to the CUBE set
	                            distinctCubes.add(cube);
	                        }
	                    }
	                }
	            }
	        }
	    }
	    
	    return distinctCubes;
	}
}
