package model;

import java.util.List;
import java.util.Set;

/**
 * Public interface for the fighter
 * @author wolfa
 *
 *  methods will be called by pilot
 */
public interface IBiplane {

	public void goForward(int speed) throws OutOfFuelException;
	
	public void turnLeft(int angularVelocity) throws OutOfFuelException;
	
	public void turnRight(int angularVelocity) throws OutOfFuelException;
	
	public void zigZag(int frequency) throws OutOfFuelException;
	
	/**
	 * 
	 * @return percentage of damage
	 */
	public double getDamage();
	
	public void takeDamage(int rounds);
	
	/**
	 * 
	 * @param rounds
	 * @throws OutOfAmmoException
	 */
	public Set<IRound> fire(int rounds) throws OutOfAmmoException;
	
	/**
	 * 
	 * @return All unfired shots
	 */
	public int getAmmo();
	
	public void reload(int rounds);
	
	public int getFuel();
	
	public void reFuel(int gallons);

	public boolean isAlive();

	public void die();
	
	public IAlarmSuite updateLocation(INormalizedMap map);

	public Position getPosition();
	
}
