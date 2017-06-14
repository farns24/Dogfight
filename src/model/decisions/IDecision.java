package model.decisions;

import model.Base;
import model.Boundaries;
import model.Enemy;
import model.Obstical;
import states.State;

import java.util.List;

/**
 * Created by michael on 6/12/17.
 */
public interface IDecision {
    public void execute();
    public GameState simulate(boolean isAlive, int fuelLeft, double damage, int ammoLeft, List<Enemy> enemies,
                              List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals, State state);
}
