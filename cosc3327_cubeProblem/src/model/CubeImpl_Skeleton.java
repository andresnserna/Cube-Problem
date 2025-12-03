package model;

import java.util.Set;

public class CubeImpl_Skeleton implements Cube
{	
	private int hashCodeCallCount;
	private int equalsCallCount;
	
	public CubeImpl_Skeleton(CubeNet cubeNetRepresentative)
	{
		assert cubeNetRepresentative != null : "cubeNetRepresentative is null!";

		hashCodeCallCount = 0;
		equalsCallCount = 0;
		
		//validate cubenetrepresentative
		
		//compute the 24 rotated versions
		//how do i do that? do i have to call upon the representative? but getRotationofthecube is static so what dos it mean to compute the rotated cubes?
		
		//store them in a set of cube nets, and because of my hashcode it should remove duplicates
	}

	@Override
	public Set<CubeNet> getAllPossibleCubeNets()
	{
		throw new RuntimeException("NOT IMPLEMENTED YET!");
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
		//can this use my same hashcode from the cubenet impl? or does this one have to be different?
		throw new RuntimeException("NOT IMPLEMENTED YET!");
	}
	
	public boolean equals()
	{
		equalsCallCount++;
		throw new RuntimeException("NOT IMPLEMENTED YET!");
	}
}