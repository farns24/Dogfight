package model.decisions;

import model.*;
import Conditions.Conditions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 6/12/17.
 */
public class GameState {

    IDecision actionTook;
    boolean isAlive;
    int fuelLeft;
    double damage;
    int ammoLeft;
    List<Enemy> enemies;
    List<Boundaries> bounds;
    List<Base> bases;
    List<Obstical> obsticals;
    Conditions conditions;

    public GameState(boolean isAlive, int fuelLeft, double damage, int ammoLeft, List<Enemy> enemies,
                     List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals, Conditions conditions) {
        this.actionTook = null;
        this.isAlive = isAlive;
        this.fuelLeft = fuelLeft;
        this.damage = damage;
        this.ammoLeft = ammoLeft;
        this.enemies = enemies;
        this.bounds = bounds;
        this.bases = bases;
        this.obsticals = obsticals;
        this.conditions = conditions;
    }

    public GameState(IDecision actionTook, boolean isAlive, int fuelLeft, double damage, int ammoLeft,
                     List<Enemy> enemies, List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals,
                     Conditions conditions) {
        this.actionTook = actionTook;
        this.isAlive = isAlive;
        this.fuelLeft = fuelLeft;
        this.damage = damage;
        this.ammoLeft = ammoLeft;
        this.enemies = enemies;
        this.bounds = bounds;
        this.bases = bases;
        this.obsticals = obsticals;
        this.conditions = conditions;
    }

    public boolean isTerminal() {
        if(!isAlive) return true;
        boolean enemiesRemain = false;
        for (Enemy enemy : enemies) {
            enemiesRemain = enemiesRemain || enemy.isAlive();
        }
        return !enemiesRemain;
    }

    public List<GameState> getPosFutures(Pilot p, boolean maximizingPlayer) {
        List<GameState> list = new ArrayList<>();
        IBiplane plane = p.getPlane();
        GameState newState = null;
        Conditions conditions = p.determineConditions();

        Refuel refuel = new Refuel();
        newState = refuel.simulate(p.isAlive(), plane.getFuel(), plane.getDamage(), plane.getAmmo(),
                        enemies, bounds, bases, obsticals, conditions);
        list.add(newState);

        Reload reload = new Reload();
        newState = reload.simulate(p.isAlive(), plane.getFuel(), plane.getDamage(), plane.getAmmo(),
                enemies, bounds, bases, obsticals, conditions);
        list.add(newState);

        Fire fire = new Fire();
        newState = fire.simulate(p.isAlive(), plane.getFuel(), plane.getDamage(), plane.getAmmo(),
                enemies, bounds, bases, obsticals, conditions);
        list.add(newState);

        SlowDown slowDown = new SlowDown(1);
        newState = slowDown.simulate(p.isAlive(), plane.getFuel(), plane.getDamage(), plane.getAmmo(),
                enemies, bounds, bases, obsticals, conditions);
        list.add(newState);

        SpeedUp speedUp = new SpeedUp(1);
        newState = speedUp.simulate(p.isAlive(), plane.getFuel(), plane.getDamage(), plane.getAmmo(),
                enemies, bounds, bases, obsticals, conditions);
        list.add(newState);

        SwerveLeft swerveLeft = new SwerveLeft(plane, 5);
        newState = swerveLeft.simulate(p.isAlive(), plane.getFuel(), plane.getDamage(), plane.getAmmo(),
                enemies, bounds, bases, obsticals, conditions);
        list.add(newState);

        SwerveRight swerveRight = new SwerveRight(5);
        newState = swerveRight.simulate(p.isAlive(), plane.getFuel(), plane.getDamage(), plane.getAmmo(),
                enemies, bounds, bases, obsticals, conditions);
        list.add(newState);

        return list;
    }

    public double getScore() {
        double score = 0;
        for (Enemy enemy : enemies) {
            score += enemy.getPlane().getDamage();
        }
        return score;
    }

    public IDecision getActionTaken() {
        return actionTook;
    }

    public void setAction(IDecision action) {
        this.actionTook = action;
    }

    public int getFuelLeft() {
        return fuelLeft;
    }

    public void setFuelLeft(int fuelLeft) {
        this.fuelLeft = fuelLeft;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setAmmoLeft(int ammoLeft) {
        this.ammoLeft = ammoLeft;
    }

    public Conditions getConditions() {
        return conditions;
    }

    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }
}
