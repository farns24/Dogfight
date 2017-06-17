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
                false, false, false, false,
                false, false);
        currentState.setConditions(c);

        GameState result = swerveLeft.simulate(currentState);
        Conditions rc = result.getConditions();
        assert(!rc.ENEMYINSIGHTS());
        assert(!rc.INENEMYSIGHTS());
//        assert(!rc.OUTOFAMMO());
//        assert(!rc.OUTOFFUEL());
//        assert(result.getFuelLeft() < 10);
    }

    @Test
    public void simulation2() throws Exception {
        Conditions c = new Conditions(true, true, false, false,
                false, false, false, false,
                false, false);
        currentState.setConditions(c);
        currentState.setFuelLeft(1);

        GameState result = swerveLeft.simulate(currentState);
        Conditions rc = result.getConditions();
        assert(!rc.ENEMYINSIGHTS());
        assert(!rc.INENEMYSIGHTS());
//        assert(!rc.OUTOFAMMO());
//        assert(rc.OUTOFFUEL());
//        assert(result.getFuelLeft() < 1);
    }

    @Test
    public void simulation3() throws Exception {
        Conditions c = new Conditions(true, true, false, false,
                true, false, false, false,
                false, false);
        currentState.setConditions(c);
        currentState.setFuelLeft(0);

        GameState result = swerveLeft.simulate(currentState);
        Conditions rc = result.getConditions();
        assert(rc.ENEMYINSIGHTS());
        assert(rc.INENEMYSIGHTS());
//        assert(!rc.OUTOFAMMO());
//        assert(rc.OUTOFFUEL());
//        assert(result.getFuelLeft() == 0);
    }

    @Test
    public void simulation4() throws Exception {
        Conditions c = new Conditions(false, false, false, false,
                false, true, false, false,
                false, false);
        currentState.setConditions(c);

        GameState result = swerveLeft.simulate(currentState);
        Conditions rc = result.getConditions();
        assert(!rc.ENEMYINSIGHTS());
        assert(!rc.INENEMYSIGHTS());
//        assert(!rc.OUTOFAMMO());
//        assert(!rc.OUTOFFUEL());
        assert(!rc.APPROACHINGOBSTACLE());
//        assert(result.getFuelLeft() < 10);
    }

    @Test
    public void simulation5() throws Exception {
        Conditions c = new Conditions(false, false, false, false,
                true, true, false, false,
                false, false);
        currentState.setConditions(c);
        currentState.setFuelLeft(0);

        GameState result = swerveLeft.simulate(currentState);
        Conditions rc = result.getConditions();
        assert(!rc.ENEMYINSIGHTS());
        assert(!rc.INENEMYSIGHTS());
//        assert(!rc.OUTOFAMMO());
//        assert(rc.OUTOFFUEL());
        assert(rc.APPROACHINGOBSTACLE());
    }

}