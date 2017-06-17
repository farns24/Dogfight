package model.decisions;

import model.IBiplane;

/**
 * Created by michael on 6/12/17.
 */
public class SlowDown implements IDecision {

    private int decrease;

    public SlowDown(int decrease) {
        this.decrease = decrease;
    }

    @Override
    public void execute(IBiplane p) {

    }

    @Override
    public GameState simulate(GameState currentState) {
        return null;
    }
}
