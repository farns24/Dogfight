package model.decisions;

import Conditions.Conditions;
import model.*;

import java.util.List;

/**
 * Created by michael on 6/16/17.
 */
public class Forward implements IDecision {

    private IBiplane plane;
    private int fuelConsumption;

    public Forward(IBiplane plane) {
        this.plane = plane;
        this.fuelConsumption = 1;
    }

    @Override
    public void execute() {

    }

    @Override
    public GameState simulate(boolean isAlive, int fuelLeft, double damage, int ammoLeft, List<Enemy> enemies,
                              List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals, Conditions c) {

        GameState newState = new GameState(new Forward(plane), isAlive, fuelLeft, damage, ammoLeft, enemies, bounds,
                bases, obsticals, c);

        if (c.OUTOFFUEL() && c.INENEMYSIGHTS()) {
            newState.setDamage(damage + .1);
        } else if (c.ENEMYINSIGHTS()) {
            //Move self
        } else if (c.INENEMYSIGHTS()) {
            //Move self
            newState.setDamage(damage + .1);
        } else if (c.APPROACHINGOBSTACLE()) {
            //Move self
            newState.setAlive(false);
        } else if (c.SEARCHING()) {
            //Move self
        }
        //Test if approaching obstacle
        //Change enemies positions && change ENEMYINSIGHTS, INENEMYSIGHTS and SEARCHING accordingly
        newState.setFuelLeft(fuelLeft - fuelConsumption);

        return newState;
    }
}