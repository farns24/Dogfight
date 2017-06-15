package model;

import states.State;

import java.util.List;

public abstract class Pilot implements IPilot{

	protected IBiplane plane;

	public Pilot(IBiplane plane)
	{
		this.plane = plane;
	}

	public boolean isAlive() {
		return plane.isAlive();
	}

	public IBiplane getPlane() {
		return plane;
	}

	public State determineState() {
		return null;
	}

	@Override
	public void respondToEnvironment(INormalizedMap map) {
		
		plane.updateLocation(map);
		
		int remainingFuel = plane.getFuel();
		
		double damage = plane.getDamage();
		
		int ammo = plane.getAmmo();

		boolean isAlive = plane.isAlive();
		
		List<EnemyPosition> enemies = map.getEnemies();
		
		List<Boundaries> bounds = map.getBounds();
		
		List<Base> bases = map.getBases();
		
		List<Obstical> obsticals = map.getObsticals();

		respond(isAlive, remainingFuel,damage,ammo,enemies,bounds,bases,obsticals);
	}
	

	public abstract void respond(boolean isAlive, int fuelLeft, double damage, int ammoLeft, List<EnemyPosition> enemies,
								 List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals);

	
}
