package model.decisions;

import model.Base;
import model.Boundaries;
import model.Enemy;
import model.Obstical;

import java.util.List;

/**
 * Created by michael on 6/12/17.
 */
public class SwerveLeft implements IDecision {

    private int speed;

    public SwerveLeft(int speed) {
        this.speed = speed;
    }

    @Override
    public void execute() {

    }

    @Override
    public GameState simulate(boolean isAlive, int fuelLeft, double damage, int ammoLeft, List<Enemy> enemies,
                         List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals) {
        return null;
    }
}
