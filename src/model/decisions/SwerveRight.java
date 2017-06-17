package model.decisions;

import Conditions.Conditions;
import model.*;

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
    public void execute(IBiplane p) {
        try {
            p.turnRight(1);
        } catch (OutOfFuelException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GameState simulate(GameState currentState) {

        GameState newState = currentState;
        newState.setAction(new SwerveRight(plane, 5));
        Conditions c = currentState.getConditions();

        if (c.OUTOFFUEL() && c.INENEMYSIGHTS()) {
            newState.setDamage(currentState.getDamage() + .1);
        }
        if (c.ENEMYINSIGHTS() && !c.OUTOFFUEL()) {
            newState.getConditions().setENEMYINSIGHTS(false);
        }
        if (c.INENEMYSIGHTS() && !c.OUTOFFUEL()) {
            newState.getConditions().setINENEMYSIGHTS(false);
        }
        if (c.APPROACHINGOBSTACLE() && !c.OUTOFFUEL()) {
            newState.getConditions().setAPPROACHINGOBSTACLE(false);
        }
        if (!c.OUTOFFUEL()) {
            //Move Self
            if (c.OBSTICALTORIGHT()) {
                newState.setAlive(false);
            } else {
//                newState.setFuelLeft(currentState.getFuelLeft() - fuelConsumption);
//                if (newState.getFuelLeft() < fuelConsumption) {
//                    newState.getConditions().setOUTOFFUEL(true);
//                }
            }
        }
        //Test if approaching obstacle
        //Change enemies positions && change ENEMYINSIGHTS, INENEMYSIGHTS and SEARCHING accordingly

        return newState;
    }
}
