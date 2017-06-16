package model.decisions;

import model.*;

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
    public GameState simulate(GameState currentState) {

        GameState newState = currentState;
        newState.setAction(new SwerveLeft(plane, 5));

        if (currentState.getConditions().OUTOFFUEL() && currentState.getConditions().INENEMYSIGHTS()) {
            newState.setDamage(currentState.getDamage() + .1);
        } else if (currentState.getConditions().ENEMYINSIGHTS()) {
            newState.getConditions().setENEMYINSIGHTS(false);
        } else if (currentState.getConditions().INENEMYSIGHTS()) {
            newState.getConditions().setINENEMYSIGHTS(false);
        } else if (currentState.getConditions().APPROACHINGOBSTACLE()) {
            newState.getConditions().setAPPROACHINGOBSTACLE(false);
        }
        if (!currentState.getConditions().OUTOFFUEL()) {
            //Move Self
            newState.setFuelLeft(currentState.getFuelLeft() - fuelConsumption);
            if (newState.getFuelLeft() < fuelConsumption) {
                newState.getConditions().setOUTOFFUEL(true);
            }
        }
        //Test if approaching obstacle
        //Change enemies positions && change ENEMYINSIGHTS, INENEMYSIGHTS and SEARCHING accordingly

        return newState;
    }
}
