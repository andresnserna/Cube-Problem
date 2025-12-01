package test;

import static model.Face.BACK;
import static model.Face.BOTTOM;
import static model.Face.FRONT;
import static model.Face.LEFT;
import static model.Face.RIGHT;
import static model.Face.TOP;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import model.Cube;
import model.CubeImpl_Skeleton;
import model.CubeNet;
import model.CubeNetImpl_Skeleton;
import model.Face;

public class CubeTests
{
	@Test
	public void cubeTest_Simple()
	{

		Map<Face, Color> faceToColorMap = new HashMap<Face, Color>();
		faceToColorMap.put(TOP, Color.BLUE);
		faceToColorMap.put(FRONT, Color.RED);
		faceToColorMap.put(LEFT, Color.GREEN);
		faceToColorMap.put(RIGHT, Color.YELLOW);
		faceToColorMap.put(BACK, Color.ORANGE);
		faceToColorMap.put(BOTTOM, Color.WHITE);
		
		CubeNet cubeNet = new CubeNetImpl_Skeleton(faceToColorMap);
		System.out.println("cubeNet = \n" + cubeNet);
		
		Cube cube = new CubeImpl_Skeleton(cubeNet);
		
		Set<CubeNet> cubeNetSet = cube.getAllPossibleCubeNets();
		
		Map<Face, Color> faceToColorMapRotation = new HashMap<Face, Color>();
		faceToColorMapRotation.put(TOP, Color.BLUE);
		faceToColorMapRotation.put(FRONT, Color.ORANGE);
		faceToColorMapRotation.put(LEFT, Color.YELLOW);
		faceToColorMapRotation.put(RIGHT, Color.GREEN);
		faceToColorMapRotation.put(BACK, Color.RED);
		faceToColorMapRotation.put(BOTTOM, Color.WHITE);
		
		CubeNet cubeNetOtherRepresentative = new CubeNetImpl_Skeleton(faceToColorMapRotation);
		System.out.println("cubeNetOtherRepresentative = \n" + cubeNetOtherRepresentative);
		
		assertTrue("cubeNetSet = " + cubeNetSet + "\n" + cubeNetOtherRepresentative + "\n", cubeNetSet.contains(cubeNetOtherRepresentative));
	}
}
