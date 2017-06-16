package model.decisions;

import model.*;
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
    public GameState simulate(GameState currentState) {

        GameState newState = currentState;
        newState.setAction(new Forward(plane));

        if (currentState.getConditions().INENEMYSIGHTS()) {
            newState.setDamage(currentState.getDamage() + .1);
        }else if (currentState.getConditions().APPROACHINGOBSTACLE()) {
            newState.setAlive(false);
        }
        if (!currentState.getConditions().OUTOFFUEL()) {
            //move self
            newState.setFuelLeft(currentState.getFuelLeft()-fuelConsumption);
            if (newState.getFuelLeft() < fuelConsumption) {
                newState.getConditions().setOUTOFFUEL(true);
            }
        }
        //Test if approaching obstacle
        //Change enemies positions && change ENEMYINSIGHTS, INENEMYSIGHTS and SEARCHING accordingly

        return newState;
    }
}
