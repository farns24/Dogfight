package model.decisions;

import model.IBiplane;

/**
 * Created by michael on 6/12/17.
 */
public class SpeedUp implements IDecision {

    private int increase;

    public SpeedUp(int increase) {
        this.increase = increase;
    }

    @Override
    public void execute(IBiplane p) {

    }

    @Override
    public GameState simulate(GameState currentState) {
        return null;
    }
}
