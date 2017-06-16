package test.decisionTests;

import Conditions.Conditions;
import model.BasicPilot;
import model.Biplane;
import model.IBiplane;
import model.Pilot;
import model.decisions.GameState;
import model.decisions.SwerveLeft;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by michael on 6/16/17.
 */
public class SwerveLeftTest {
    IBiplane plane;
    Pilot pilot;
    GameState currentState;
    SwerveLeft swerveLeft;

    @Before
    public void setUp() throws Exception {
        plane = new Biplane();
        pilot = new BasicPilot(plane);
        currentState = new GameState(true, 10, 0, 10, null, null,
                null, null, null);
        swerveLeft = new SwerveLeft(plane, 5);
    }

    @Test
    public void simulation1() throws Exception {
        Conditions c = new Conditions(true, true, false, false,
                false, false);
        currentState.setConditions(c);
        GameState result = swerveLeft.simulate(currentState);
    }

}