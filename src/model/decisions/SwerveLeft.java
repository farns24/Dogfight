package model.decisions;

import model.*;
import Conditions.Conditions;

import java.util.List;

/**
 * Created by michael on 6/12/17.
 */
public class SwerveLeft implements IDecision {

    private IBiplane plane;
    private int speed;
    private int fuelConsumption;

    public SwerveLeft(IBiplane plane, int speed) {
        this.plane = plane;
        this.speed = speed;
        this.fuelConsumption = 1;
    }

    @Override
    public void execute() {

    }

    @Override
    public GameState simulate(boolean isAlive, int fuelLeft, double damage, int ammoLeft, List<Enemy> enemies,
                              List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals, Conditions c) {

        GameState newState = new GameState(new SwerveLeft(plane, 5), isAlive, fuelLeft, damage, ammoLeft,
                enemies, bounds, bases, obsticals, c);

        if (c.OUTOFFUEL() && c.INENEMYSIGHTS()) {
            newState.setDamage(damage + .1);
        } else if (c.ENEMYINSIGHTS()) {
            //Move self
            newState.getConditions().setENEMYINSIGHTS(false);
        } else if (c.INENEMYSIGHTS()) {
            //Move self
            newState.getConditions().setINENEMYSIGHTS(false);
        } else if (c.APPROACHINGOBSTACLE()) {
            //Move self
            newState.getConditions().setAPPROACHINGOBSTACLE(false);
        } else if (c.SEARCHING()) {
            //Test if enemy comes into sight and change accordingly
        }
        //Test if approaching obstacle
        //Change enemies positions && change ENEMYINSIGHTS and INENEMYSIGHTS accordingly
        newState.setFuelLeft(fuelLeft - fuelConsumption);

        return newState;
    }
}
