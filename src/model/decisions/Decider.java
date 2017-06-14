package model.decisions;

import model.*;

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

    public boolean isTerminal() {
        //Not yet implemented
        return true;
    }

    public List<Decider> getPosFutures(Pilot p, boolean maximizingPlayer) {
        //Not yet implemented
        return null;
    }

    public int getScore(Pilot p) {
        //Not yet implemented
        return 0;
    }
}
