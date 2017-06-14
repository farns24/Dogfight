package alpha_beta;

import model.Pilot;
import model.decisions.Decider;

import java.util.List;

public class AlphaBetaSolver {
	public AlphaBetaResult alphabeta(Decider decider, int depth, int alphaBound, int betaBound, Boolean maximizingPlayer, Pilot pilot) {
		int v;
		if (depth == 0 || decider.isTerminal()) {
			return new AlphaBetaResult(decider.getScore(pilot), decider);
		}
		if (maximizingPlayer) {
			v = Integer.MIN_VALUE;
			Decider bestChild = null;
			List<Decider> posFutures = decider.getPosFutures(pilot,maximizingPlayer);
			if (posFutures.size()==0) {
				return new AlphaBetaResult(0, decider);
			}
			if (posFutures.size()==1)
			{
				return new AlphaBetaResult(0, posFutures.get(0));
			}
			for (Decider child : posFutures) {

				//Look deeper if considering corner
				int score = alphabeta(child, depth - 1, alphaBound, betaBound, false, pilot).getValue();
				if (score>v)
				{
					bestChild = child;
					v = score;
					alphaBound = max(alphaBound, v);
					if (betaBound <= alphaBound) {
						break;
					}
				}
				
				//
				//v = max(v, alphabeta(child, depth - 1, alphaBound, betaBound, false,player));
				
				//Find out which child produced the best answer
				
			}
			return new AlphaBetaResult(v, bestChild);
		} else {
			v = Integer.MAX_VALUE;
			Decider bestChild = null;
			List<Decider> posFutures = decider.getPosFutures(pilot,maximizingPlayer);
			if (posFutures.size()==0) {
				return new AlphaBetaResult(0, decider);
			}
			if (posFutures.size()==1)
			{
				return new AlphaBetaResult(0, posFutures.get(0));
			}
			
			
			for (Decider child : posFutures) {
				
				int score = alphabeta(child, depth - 1, alphaBound, betaBound, true, pilot).getValue();
				
				if (score<v)
				{
					v= score;
					bestChild = child;
					betaBound = min(betaBound, v);
					if (betaBound <= alphaBound) {
						break;
					}

				}
	//			v = min(v, alphabeta(child, depth - 1, alphaBound, betaBound, true,player));
				
//				return v;
			}
			return new AlphaBetaResult(v, bestChild);
		}
	}

	private int min(int v, int alphabeta) {

		if (v < alphabeta) {
			return v;
		}

		return alphabeta;
	}

	private int max(int v, int alphabeta) {
		if (v > alphabeta) {
			return v;
		}
		return alphabeta;
	}
}