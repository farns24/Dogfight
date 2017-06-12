package model;

import java.util.List;

public abstract class Pilot implements IPilot{

	protected IBiplane plane;

	public Pilot(IBiplane plane)
	{
		this.plane = plane;
	}
	
	@Override
	public void respondToEnvironment(INormalizedMap map) {
		
		plane.updateLocation(map);
		
		int remainingFuel = plane.getFuel();
		
		double damage = plane.getDamage();
		
		int ammo = plane.getAmmo();
		
		List<Enemy> enemies = map.getEnemies();
		
		List<Boundaries> bounds = map.getBounds();
		
		List<Base> bases = map.getBases();
		
		List<Obstical> obsticals = map.getObsticals();
		respond(remainingFuel,damage,ammo,enemies,bounds,bases,obsticals);
	}
	
	public abstract void respond(int fuelLeft, double damage, int ammoLeft, List<Enemy> enemies, List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals);
	
}
