package model.decisions;

import model.*;
import Conditions.Conditions;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Created by michael on 6/12/17.
 */
public class Fire implements IDecision {

    int ammoUsed;

    public Fire() {
        ammoUsed = 1;
    }

    @Override
    public void execute() {

    }

    @Override
    public GameState simulate(boolean isAlive, int fuelLeft, double damage, int ammoLeft, List<Enemy> enemies,
                              List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals, Conditions c) {

        GameState newState = new GameState(new Fire(), isAlive, fuelLeft, damage, ammoLeft, enemies, bounds, bases,
                obsticals, c);

        if (c.INENEMYSIGHTS()) {
            newState.setDamage(damage + .1);
        } else if (c.ENEMYINSIGHTS() && !c.OUTOFAMMO()) {
                //Damage appropriate enemy
        } else if (c.APPROACHINGOBSTACLE() && !c.OUTOFFUEL()) {
            newState.setAlive(false);
        }
        if (!c.OUTOFAMMO()) {
            newState.setAmmoLeft(ammoLeft-ammoUsed);
            if (newState.getAmmoLeft() < ammoUsed) {
                newState.getConditions().setOUTOFAMMO(true);
            }
        }
        //Change enemies positions && change ENEMYINSIGHTS, INENEMYSIGHTS and SEARCHING accordingly
        return newState;
    }
}
