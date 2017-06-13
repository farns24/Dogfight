package model;

import model.decisions.Decider;
import model.decisions.IDecision;

import java.util.List;

/**
 * Created by michael on 6/12/17.
 */
public class BasicPilot extends Pilot {

    public BasicPilot(IBiplane plane) {
        super(plane);
    }

    @Override
    public void respond(int fuelLeft, double damage, int ammoLeft, List<Enemy> enemies, List<Boundaries> bounds,
                        List<Base> bases, List<Obstical> obsticals) {
        Decider d = new Decider();
        IDecision decision = d.decide(fuelLeft, damage, ammoLeft, enemies, bounds, bases, obsticals);
        decision.execute();
    }
}
