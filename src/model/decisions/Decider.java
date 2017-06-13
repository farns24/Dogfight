package model.decisions;

import model.Base;
import model.Boundaries;
import model.Enemy;
import model.Obstical;

import java.util.List;

/**
 * Created by michael on 6/12/17.
 */
public class Decider {

    public IDecision decide(int fuelLeft, double damage, int ammoLeft, List<Enemy> enemies, List<Boundaries> bounds,
                            List<Base> bases, List<Obstical> obsticals) {
        //Alpha-beta pruning here
        return null;
    }
}
