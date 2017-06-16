package model.decisions;

import model.*;
import Conditions.Conditions;

import java.util.List;

/**
 * Created by michael on 6/12/17.
 */
public class SwerveRight implements IDecision {

    private IBiplane plane;
    private int speed;
    private int fuelConsumption;

    public SwerveRight(IBiplane plane, int speed) {
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

        GameState newState = new GameState(new SwerveRight(plane, 5), isAlive, fuelLeft, damage, ammoLeft,
                enemies, bounds, bases, obsticals, c);


        if (c.OUTOFFUEL() && c.INENEMYSIGHTS()) {
            newState.setDamage(damage + .1);
        } else if (c.ENEMYINSIGHTS()) {
            newState.getConditions().setENEMYINSIGHTS(false);
        } else if (c.INENEMYSIGHTS()) {
            newState.getConditions().setINENEMYSIGHTS(false);
        } else if (c.APPROACHINGOBSTACLE()) {
            newState.getConditions().setAPPROACHINGOBSTACLE(false);
        }
        if (!c.OUTOFFUEL()) {
            //Move Self
            newState.setFuelLeft(fuelLeft - fuelConsumption);
            if (newState.getFuelLeft() < fuelConsumption) {
                newState.getConditions().setOUTOFFUEL(true);
            }
        }
        //Test if approaching obstacle
        //Change enemies positions && change ENEMYINSIGHTS, INENEMYSIGHTS and SEARCHING accordingly

        return newState;
    }
}
