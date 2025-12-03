package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.awt.Color;

public class CubeImpl_Serna implements Cube
{	
	private int hashCodeCallCount;
	private int equalsCallCount;
	private Set<CubeNet> allRotations;
	
	public CubeImpl_Serna(CubeNet cubeNetRepresentative)
	{
		assert cubeNetRepresentative != null : "cubeNetRepresentative is null!";
		for (Face face : Face.values()) {
			// Validate that all faces have colors
		    assert cubeNetRepresentative.getColor(face) != null : "Face " + face + " has null color!";
		}

		hashCodeCallCount = 0;
		equalsCallCount = 0;
				
		//compute the 24 rotated versions
		Set<Permutation<Face>> rotations = PermutationDepot_Serna.getRotationsOfTheCube();
	    allRotations = new HashSet<>();

		for (Permutation<Face> rotation : rotations) {
		    // map of rotated cube nets
		    Map<Face, Color> rotatedFaceToColor = new HashMap<>();
		    
		    for (Face face : Face.values()) {
		    	//find the face it rotated to
		        Face rotatedFace = rotation.getImage(face);
		        //find the color from the representative
		        Color colorAtOriginalFace = cubeNetRepresentative.getColor(face);
		        rotatedFaceToColor.put(rotatedFace, colorAtOriginalFace);
		    }
		    
		    //new CubeNet with rotated mapping
		    CubeNet rotatedNet = new CubeNetImpl_Serna(rotatedFaceToColor);
			//store them in a set of cube nets, and because of my hashcode it should remove duplicates
		    allRotations.add(rotatedNet);
		}
		
	}

	@Override
	public Set<CubeNet> getAllPossibleCubeNets()
	{
		return allRotations;
	}

	@Override
	public int getCountHashCodeCalls()
	{
		return hashCodeCallCount;
	}

	@Override
	public int getCountEqualsCalls()
	{
		return equalsCallCount;
	}
	
	public int hashCode()
	{
		hashCodeCallCount++;
		
		CubeNet smallestCubeNet = null;
	    
	    for (CubeNet cubeNet : getAllPossibleCubeNets()) {
	        if (smallestCubeNet == null || 
	            CubeNetComparatorImpl_Serna.TLFRBB_COLOR_COMPARATOR.compare(cubeNet, smallestCubeNet) < 0) {
	            smallestCubeNet = cubeNet;
	        }
	    }
	    
	    return smallestCubeNet.hashCode();
	}
	
	public boolean equals(Object obj) 
	{
	    equalsCallCount++;
	    
	    if (obj == null || !(obj instanceof Cube)) {
	        return false;
	    }
	    
	    Cube other = (Cube) obj;
	    
	    // if they have the same set of rotations they're equal
	    return this.getAllPossibleCubeNets().equals(other.getAllPossibleCubeNets());
	}
}