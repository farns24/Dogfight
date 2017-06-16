package model;

import java.util.Arrays;
import java.util.List;

public class BritishPilot extends Pilot{

	public BritishPilot(IBiplane plane) {
		super(plane);
	}

	@Override
	public void respond(boolean isAlive, int fuelLeft, double damage, int ammoLeft, List<EnemyPosition> enemies,
			List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals) {
		
		try {
			plane.turnLeft(1);
			
//			for (Boundaries bound: bounds)
//			{
//				if (Math.abs(bound.getCoord()[0])<10 &&Math.abs(bound.getCoord()[1])<20)
//				{
//					System.out.println(Arrays.toString(bound.getCoord()));
//					
//					return;
//				}
//			}
//			plane.goForward(3);
			//plane.turnLeft(1);
		} catch (OutOfFuelException e) {
			
			e.printStackTrace();
		}
		
		
	}

	


}
