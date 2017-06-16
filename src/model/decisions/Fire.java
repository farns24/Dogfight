package model.decisions;

import model.*;
import Conditions.Conditions;

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
                              List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals, Conditions conditions) {
//        GameState newState = new GameState(new Fire(), isAlive, fuelLeft, damage, ammoLeft, enemies, bounds, bases,
//                obsticals);
//        switch (conditions) {
//            case ENEMYINSIGHTS:
//                if (ammoLeft > 0) {
//                    newState.setAmmoLeft(ammoLeft-ammoUsed);
//                    /*
//                        Targeted enemy takes damage
//                     */
//                    return newState;
//                } else {
//                    return newState;
//                }
//            case INENEMYSIGHTS:
//                break;
//            case SEARCHING:
//                break;
//            case OUTOFAMMO:
//                break;
//            case OUTOFFUEL:
//                break;
//            case APPROACHINGOBSTACLE:
//                break;
//        }
        return null;
    }
}
