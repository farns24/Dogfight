package model;

import java.util.Arrays;
import java.util.List;

import Conditions.ConditionFinder;
import Conditions.Conditions;
import alpha_beta.AlphaBetaResult;
import alpha_beta.AlphaBetaSolver;
import model.decisions.GameState;
import model.decisions.IDecision;
import potentialFields.IPotentialFields;

public class BritishPilot extends Pilot{

	private ConditionFinder cf = new ConditionFinder();
	private IPotentialFields pf;
	
	public BritishPilot(IBiplane plane) {
		super(plane);
	}

	@Override
	public void respond(boolean isAlive, int fuelLeft, double damage, int ammoLeft, List<EnemyPosition> enemies,
			List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals) {
		
		Conditions cond = cf.getConditions(enemies,bounds,bases,obsticals);
		
		
		/* Check nearfield conditions. if none exist, find far-field enemy fighter. 
		 *
		 */
		if (cond.somethingNearby()) {
			AlphaBetaSolver solver = new AlphaBetaSolver();
			AlphaBetaResult result = null;//solver.alphabeta();
			GameState gs = result.getGameState();
			IDecision decision = gs.getActionTaken();
			decision.execute();
		} else {
			pf.search(plane, enemies);
		}
		
		
		try {
//		plane.turnRight(1);
			plane.fire(12);
			
			
			//plane.goForward(5);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

	


}
