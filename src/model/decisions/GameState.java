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
    List<EnemyPosition> enemies;
    List<Boundaries> bounds;
    List<Base> bases;
    List<Obstical> obsticals;
    Conditions conditions;

    public GameState(boolean isAlive, int fuelLeft, double damage, int ammoLeft, List<EnemyPosition> enemies,
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
                     List<EnemyPosition> enemies, List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals,
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
        return enemies.size() == 0 || !isAlive;
    }

    public List<GameState> getPosFutures(Pilot p, boolean maximizingPlayer) {
        List<GameState> list = new ArrayList<>();
        IBiplane plane = p.getPlane();
        GameState newState = null;
        Conditions conditions = p.determineConditions();
        GameState currentState = new GameState(p.isAlive(), plane.getFuel(), plane.getDamage(), plane.getAmmo(),
                enemies, bounds, bases, obsticals, conditions);

//        Refuel refuel = new Refuel();
//        newState = refuel.simulate(currentState);
//        list.add(newState);

//        Reload reload = new Reload();
//        newState = reload.simulate(currentState);
//        list.add(newState);

        Fire fire = new Fire();
        newState = fire.simulate(currentState);
        list.add(newState);

//        SlowDown slowDown = new SlowDown(1);
//        newState = slowDown.simulate(currentState);
//        list.add(newState);

//        SpeedUp speedUp = new SpeedUp(1);
//        newState = speedUp.simulate(currentState);
//        list.add(newState);

        SwerveLeft swerveLeft = new SwerveLeft(plane, 5);
        newState = swerveLeft.simulate(currentState);
        list.add(newState);

        SwerveRight swerveRight = new SwerveRight(plane, 5);
        newState = swerveRight.simulate(currentState);
        list.add(newState);

        Forward forward = new Forward(plane);
        newState = forward.simulate(currentState);
        list.add(newState);

        return list;
    }

    public double getScore() {
        if (conditions.ENEMYINSIGHTS()) {
            return 1;
        } else if (conditions.INENEMYSIGHTS()) {
            return -1;
        } else {
            return 0;
        }
    }

//    public GameState hardCopy() {
//        List<Enemy> newEnemies = new ArrayList<>();
//        for (Enemy e : enemies) {
//            IBiplane ePlane = e.getPlane();
//            IBiplane newPlane = new FlightSimulator();
//            Enemy newEnemy = new Enemy(newPlane);
//        }
//
//        List<Boundaries> newBounds = new ArrayList<>();
//        List<Base> newBases = new ArrayList<>();
//        List<Obstical> newObsticals = new ArrayList<>();
//        Conditions newConditions = new Conditions(conditions.ENEMYINSIGHTS(), conditions.INENEMYSIGHTS(),
//                conditions.SEARCHING(),conditions.OUTOFAMMO(),conditions.OUTOFFUEL(),conditions.APPROACHINGOBSTACLE(),
//                conditions.OBSTICALTORIGHT(),conditions.OBSTICALTOLEFT(),conditions.ENEMYTOLEFT(),conditions.ENEMYTORIGHT());
//
//
//        GameState newState = new GameState()
//    }

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

    public int getAmmoLeft() {
        return ammoLeft;
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

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public IDecision getActionTook() {
        return actionTook;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public double getDamage() {
        return damage;
    }
}
