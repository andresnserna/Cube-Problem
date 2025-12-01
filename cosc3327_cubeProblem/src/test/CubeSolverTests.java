package test;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import model.Cube;
import model.CubeSolverImpl_Skeleton;

public class CubeSolverTests extends CubeTests
{
	@Test(timeout=100)
	public void oneColor_GenerousTimeout()
	{
		Set<Color> oneColor = new HashSet<Color>(Arrays.asList(new Color[]{Color.RED}));
		
		Set<Cube> cubeSet = CubeSolverImpl_Skeleton.getDistinctSolidCubes(oneColor);
		
		assertEquals(1, cubeSet.size());
	}
	
	@Test(timeout=30)
	public void oneColor()
	{
		Set<Color> oneColor = new HashSet<Color>(Arrays.asList(new Color[]{Color.RED}));
		
		Set<Cube> cubeSet = CubeSolverImpl_Skeleton.getDistinctSolidCubes(oneColor);
		
		assertEquals(1, cubeSet.size());
	}

	@Test(timeout=1200)
	public void twoColors_GenerousTimeout()
	{
		Set<Color> twoColors = new HashSet<Color>(Arrays.asList(new Color[]{Color.RED, Color.GREEN}));
		
		Set<Cube> cubeSet = CubeSolverImpl_Skeleton.getDistinctSolidCubes(twoColors);
		assertEquals(10, cubeSet.size());
	}

	@Test(timeout=400)
	public void twoColors()
	{
		Set<Color> twoColors = new HashSet<Color>(Arrays.asList(new Color[]{Color.RED, Color.GREEN}));
		
		Set<Cube> cubeSet = CubeSolverImpl_Skeleton.getDistinctSolidCubes(twoColors);
		assertEquals(10, cubeSet.size());
	}
	
	@Test(timeout=1300)
	public void threeColors_GenerousTimeout()
	{
		Set<Color> threeColors = new HashSet<Color>(Arrays.asList(new Color[]{Color.RED, Color.GREEN, Color.BLUE}));
		
		Set<Cube> cubeSet = CubeSolverImpl_Skeleton.getDistinctSolidCubes(threeColors);
		assertEquals(57, cubeSet.size());
	}
	
	@Test(timeout=500)
	public void threeColors()
	{
		Set<Color> threeColors = new HashSet<Color>(Arrays.asList(new Color[]{Color.RED, Color.GREEN, Color.BLUE}));
		
		Set<Cube> cubeSet = CubeSolverImpl_Skeleton.getDistinctSolidCubes(threeColors);
		assertEquals(57, cubeSet.size());
	}
	
	@Test(timeout=10000)
	public void fourColors_GenerousTimeout()
	{
		Set<Color> fourColors = new HashSet<Color>(Arrays.asList(new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.CYAN}));
		
		Set<Cube> cubeSet = CubeSolverImpl_Skeleton.getDistinctSolidCubes(fourColors);
		assertEquals(240, cubeSet.size());
	}
	
	@Test(timeout=600)
	public void fourColors()
	{
		Set<Color> fourColors = new HashSet<Color>(Arrays.asList(new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.CYAN}));
		
		Set<Cube> cubeSet = CubeSolverImpl_Skeleton.getDistinctSolidCubes(fourColors);
		assertEquals(240, cubeSet.size());
	}
	
	@Test(timeout=120000)
	public void fiveColors_GenerousTimeout()
	{
		Set<Color> fiveColors = new HashSet<Color>(Arrays.asList(new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.YELLOW}));
		
		Set<Cube> cubeSet = CubeSolverImpl_Skeleton.getDistinctSolidCubes(fiveColors);
		assertEquals(800, cubeSet.size());
	}
	
	@Test(timeout=1300)
	public void fiveColors()
	{
		Set<Color> fiveColors = new HashSet<Color>(Arrays.asList(new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.YELLOW}));
		
		Set<Cube> cubeSet = CubeSolverImpl_Skeleton.getDistinctSolidCubes(fiveColors);
		assertEquals(800, cubeSet.size());
	}

	@Test(timeout=1000000)
	public void sixColors_GenerousTimeout()
	{
		Set<Color> sixColors = new HashSet<Color>(Arrays.asList(new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.YELLOW, Color.MAGENTA}));
		
		Set<Cube> cubeSet = CubeSolverImpl_Skeleton.getDistinctSolidCubes(sixColors);
		assertEquals(2226, cubeSet.size());
	}

	@Test(timeout=5000)
	public void sixColors()
	{
		Set<Color> sixColors = new HashSet<Color>(Arrays.asList(new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.YELLOW, Color.MAGENTA}));
		
		Set<Cube> cubeSet = CubeSolverImpl_Skeleton.getDistinctSolidCubes(sixColors);
		assertEquals(2226, cubeSet.size());
	}

	@Test(timeout=31000)
	public void sevenColors()
	{
		Set<Color> sevenColors = new HashSet<Color>(Arrays.asList(new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.YELLOW, Color.MAGENTA, Color.WHITE}));
		
		Set<Cube> cubeSet = CubeSolverImpl_Skeleton.getDistinctSolidCubes(sevenColors);
		assertEquals(5390, cubeSet.size());
	}
}
