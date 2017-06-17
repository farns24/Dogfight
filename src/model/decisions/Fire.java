package model.decisions;

import model.IBiplane;
import model.OutOfAmmoException;

/**
 * Created by michael on 6/12/17.
 */
public class Fire implements IDecision {

    int ammoUsed;

    public Fire() {
        ammoUsed = 1;
    }

    @Override
    public void execute(IBiplane p) {
        try {
            p.fire(12);
        } catch (OutOfAmmoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GameState simulate(GameState currentState) {

        GameState newState = currentState;
        newState.setAction(new Fire());

        if (currentState.getConditions().INENEMYSIGHTS()) {
            newState.setDamage(currentState.getDamage() + .1);
        }
        if (currentState.getConditions().ENEMYINSIGHTS() && !currentState.getConditions().OUTOFAMMO()) {
                //Damage appropriate enemy
        }
        if (currentState.getConditions().APPROACHINGOBSTACLE() && !currentState.getConditions().OUTOFFUEL()) {
            newState.setAlive(false);
        }
        if (!currentState.getConditions().OUTOFAMMO()) {
//            newState.setAmmoLeft(currentState.getAmmoLeft()-ammoUsed);
//            if (newState.getAmmoLeft() < ammoUsed) {
//                newState.getConditions().setOUTOFAMMO(true);
//            }
        }
        //Change enemies positions && change ENEMYINSIGHTS, INENEMYSIGHTS and SEARCHING accordingly
        return newState;
    }
}
