package model;

import java.util.List;
import java.util.Set;

import audio.SoundPlayer;

public class Biplane implements IBiplane {
	SoundPlayer player = new SoundPlayer();
	private boolean isAlive = true;

	@Override
	public void goForward(int speed) throws OutOfFuelException {

		
	}

	@Override
	public void turnLeft(int angularVelocity) throws OutOfFuelException {
		// TODO Auto-generated method stub

	}

	@Override
	public void turnRight(int angularVelocity) throws OutOfFuelException {
		// TODO Auto-generated method stub

	}

	@Override
	public void zigZag(int frequency) throws OutOfFuelException {
		// TODO Auto-generated method stub

	}

	@Override
	public double getDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void takeDamage(int rounds) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<IRound> fire(int rounds) throws OutOfAmmoException {
		player.fireGuns();
		return null;
	}

	@Override
	public int getAmmo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reload(int rounds) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getFuel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reFuel(int gallons) {
		// TODO Auto-generated method stub

	}

	@Override
	public IAlarmSuite updateLocation(INormalizedMap map) {
		
		List<Base> bases = map.getBases();
		
		return null;
	}

	@Override
	public boolean isAlive() {
		return isAlive;
	}

	@Override
	public void die() {
		isAlive = false;
	}

	@Override
	public LocationScape getRadar() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Position getPosition() {
//		throw new NotImplementedException();
//	}
}
