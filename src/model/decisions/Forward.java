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

        if (c.INENEMYSIGHTS()) {
            newState.setDamage(damage + .1);
        }else if (c.APPROACHINGOBSTACLE()) {
            newState.setAlive(false);
        }
        if (!c.OUTOFFUEL()) {
            //move self
            newState.setFuelLeft(fuelLeft-fuelConsumption);
            if (newState.getFuelLeft() < fuelConsumption) {
                newState.getConditions().setOUTOFFUEL(true);
            }
        }
        //Test if approaching obstacle
        //Change enemies positions && change ENEMYINSIGHTS, INENEMYSIGHTS and SEARCHING accordingly

        return newState;
    }
}
