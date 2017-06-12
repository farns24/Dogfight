package model;

import java.util.List;

public class BritishPilot extends Pilot{

	public BritishPilot(IBiplane plane) {
		super(plane);
	}

	@Override
	public void respond(int fuelLeft, double damage, int ammoLeft, List<Enemy> enemies, List<Boundaries> bounds,
			List<Base> bases, List<Obstical> obsticals) {
	
		
		try {
			plane.goForward(5);
		} catch (OutOfFuelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




}
