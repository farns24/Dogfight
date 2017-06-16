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
                              List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals, Conditions conditions) {
        GameState newState = new GameState(new SwerveLeft(plane, 5), isAlive, fuelLeft, damage, ammoLeft,
                enemies, bounds, bases, obsticals, conditions);

        newState.setFuelLeft(fuelLeft - fuelConsumption);
        if (newState.getFuelLeft() <= 0) {}
        return newState;
    }
}
