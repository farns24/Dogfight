package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.FlightSimulator;
import model.FlightSimulatorEngine;
import model.LocationScape;

public class TestFlightSimulator {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		FlightSimulatorEngine proxy = FlightSimulatorEngine.getInstance();
		proxy.speed(3, 3, "5");
		LocationScape location = proxy.where();
		proxy.speed(3, 3, "5");
		location = proxy.where();
	}
	
	@Test
	public void testSimulator()
	{
		
	}

}
