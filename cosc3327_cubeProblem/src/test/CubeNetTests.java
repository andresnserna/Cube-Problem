package test;

import static model.Face.BACK;
import static model.Face.BOTTOM;
import static model.Face.FRONT;
import static model.Face.LEFT;
import static model.Face.RIGHT;
import static model.Face.TOP;
import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import model.CubeNet;
import model.CubeNetImpl_Skeleton;
import model.Face;

public class CubeNetTests extends CubeTests
{
	@Test
	public void cubeNetTest_Simple()
	{
		Map<Face, Color> faceToColorMap = new HashMap<Face, Color>();
		faceToColorMap.put(TOP, Color.RED);
		faceToColorMap.put(FRONT, Color.BLUE);
		faceToColorMap.put(LEFT, Color.GREEN);
		faceToColorMap.put(RIGHT, Color.CYAN);
		faceToColorMap.put(BACK, Color.YELLOW);
		faceToColorMap.put(BOTTOM, Color.MAGENTA);
		
		CubeNet cubeNet = new CubeNetImpl_Skeleton(faceToColorMap);
		assertEquals(cubeNet.getTop(), Color.RED);
		assertEquals(cubeNet.getFront(), Color.BLUE);
		assertEquals(cubeNet.getLeft(), Color.GREEN);
		assertEquals(cubeNet.getRight(), Color.CYAN);
		assertEquals(cubeNet.getBack(), Color.YELLOW);
		assertEquals(cubeNet.getBottom(), Color.MAGENTA);
	}
}
