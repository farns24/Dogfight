package model;

import alpha_beta.AlphaBetaResult;
import alpha_beta.AlphaBetaSolver;
import model.decisions.GameState;
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
        AlphaBetaSolver solver = new AlphaBetaSolver();
        AlphaBetaResult result = null;//solver.alphabeta();
        GameState d = result.getGameState();
        IDecision decision = d.getActionTaken();
        decision.execute();
    }
}
