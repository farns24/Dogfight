package test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import model.IPosition;
import model.NormalizedMap;
import model.Position;

public class TestNormalizedMap {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		IPosition fighter = new IPosition() {
			
			@Override
			public int getId() {
				// TODO Auto-generated method stub
				return 1;
			}
			
			@Override
			public double getDirection() {
				return Math.PI/6.0;
			}
			
			@Override
			public int[] getCoord() {
				return new int[]{5,5};
			}
		};
		HashMap<Integer, IPosition> pilots2Position = new HashMap<Integer,IPosition>();
		pilots2Position.put(2, new Position(0, 5, 2));
		
		NormalizedMap theBarronsMap = new NormalizedMap(fighter, pilots2Position);
		
		
		System.out.println(theBarronsMap.toString());
	}

}
