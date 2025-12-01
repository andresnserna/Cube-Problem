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
		
		throw new RuntimeException("NOT IMPLEMENTED YET!");
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
		throw new RuntimeException("NOT IMPLEMENTED YET!");
	}
	
	public boolean equals()
	{
		equalsCallCount++;
		throw new RuntimeException("NOT IMPLEMENTED YET!");
	}
}