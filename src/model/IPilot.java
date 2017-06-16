package model;

import callback.BiplaneEventListener;

/**
 * Pilot is the decison maker for the plane
 * @author wolfa
 *
 */
public interface IPilot {

	public void respondToEnvironment(INormalizedMap map, BiplaneEventListener biplaneEventListener);
}
