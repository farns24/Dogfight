package model;

import java.util.Set;

import audio.SoundPlayer;

public class FlightSimulator implements IBiplane {
	
	SoundPlayer sounds = new SoundPlayer();
	FlightSimulatorEngine engine = FlightSimulatorEngine.getInstance();
//	int speed;
	double health = 20;
	double damage = 0;
	private int ammo = 100;
	private int fuel = 300;
	
	@Override
	public void goForward(int speed) throws OutOfFuelException {
//		this.speed = speed;
		engine.speed(speed,speed, "5");
	}

	@Override
	public void turnLeft(int angularVelocity) throws OutOfFuelException {
		engine.speed(3, 3+angularVelocity,"5");

	}

	@Override
	public void turnRight(int angularVelocity) throws OutOfFuelException {
		engine.speed(3+angularVelocity, 3,"5");

	}

	@Override
	public void zigZag(int frequency) throws OutOfFuelException {
		// TODO Auto-generated method stub

	}

	@Override
	public double getDamage() {
		return damage/health;
	}

	@Override
	public void takeDamage(int rounds) {
		damage+= rounds;

	}

	@Override
	public Set<IRound> fire(int rounds) throws OutOfAmmoException {
		sounds.fireGuns();
		
		return null;
	}

	@Override
	public int getAmmo() {
		// TODO Auto-generated method stub
		return ammo;
	}

	@Override
	public void reload(int rounds) {
		ammo += rounds;

	}

	@Override
	public int getFuel() {
		// TODO Auto-generated method stub
		return fuel;
	}

	@Override
	public void reFuel(int gallons) {
		fuel  += gallons;

	}

	@Override
	public IAlarmSuite updateLocation(INormalizedMap map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAlive() {
		return false;
	}

	@Override
	public void die() {
		throw new RuntimeException("Not implimented");
//		throw new NotImplementedException();
	}

	@Override
	public LocationScape getRadar() {
		// TODO Auto-generated method stub
		return engine.where();
	}

//	@Override
//	public Position getPosition() {
//		throw new NotImplementedException();
//	}
}
