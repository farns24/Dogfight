package model.decisions;

import model.IBiplane;

/**
 * Created by michael on 6/12/17.
 */
public interface IDecision {
    public void execute(IBiplane plane);
    public GameState simulate(GameState currentState);
}
