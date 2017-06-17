package model;

import java.util.Set;

import telnet.TaskException;
import telnet.TelnetProxy;

public class SopwithCamel implements IBiplane {

	private TelnetProxy proxy;

	public SopwithCamel() {
		super();
		
		proxy = new TelnetProxy();
		try {
			proxy.connectToBot();
		} catch (TaskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void goForward(int speed) throws OutOfFuelException {
		try {
			proxy.speed(speed, speed);
		} catch (TaskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		// TODO Auto-generated method stub
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
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub

	}

	@Override
	public IAlarmSuite updateLocation(INormalizedMap map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocationScape getRadar() {
		// TODO Auto-generated method stub
		try {
			return proxy.where();
		} catch (TaskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public Position getPosition() {
//		throw new NotImplementedException();
//	}
}
