package model.decisions;

import model.*;

import java.util.List;

/**
 * Created by michael on 6/12/17.
 */
public class Decider {

    IDecision actionTook;

    public Decider(IDecision actionTook) {
        this.actionTook = actionTook;
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

    public IDecision getActionTaken() {
        return actionTook;
    }
}
