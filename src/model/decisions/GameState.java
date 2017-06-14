package model.decisions;

import model.*;

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

    public GameState(boolean isAlive, int fuelLeft, double damage, int ammoLeft, List<Enemy> enemies,
                     List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals) {
        this.actionTook = null;
        this.isAlive = isAlive;
        this.fuelLeft = fuelLeft;
        this.damage = damage;
        this.ammoLeft = ammoLeft;
        this.enemies = enemies;
        this.bounds = bounds;
        this.bases = bases;
        this.obsticals = obsticals;
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
        GameState newState = new GameState(p.isAlive(), plane.getFuel(), plane.getDamage(), plane.getAmmo(),
                enemies, bounds, bases, obsticals);

        if (p.getPlane().getFuel() == 0) {
            newState.setAction(new Refuel());
            list.add(newState);
            return list;    //Only available option
        }

        if (p.getPlane().getAmmo() == 0) {
            newState.setAction(new Reload());
            list.add(newState);
        }
        //Not yet implemented
        return null;
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
}
