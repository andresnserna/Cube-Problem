package model;

import java.util.Set;

public interface Cube
{
	public Set<CubeNet> getAllPossibleCubeNets();
	
	//NOTE: These next two methods are non-standard.
	//They will not be part of any interface that you
	//write as a professional
	public int getCountHashCodeCalls();
	public int getCountEqualsCalls();
}
