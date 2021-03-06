package alpha_beta;

import model.Pilot;
import model.decisions.GameState;

import java.util.List;

public class AlphaBetaSolver {
	public AlphaBetaResult alphabeta(GameState gameState, int depth, double alphaBound, double betaBound,
									 Boolean maximizingPlayer, Pilot pilot) {
		double v;
		if (depth == 0 || gameState.isTerminal()) {
			return new AlphaBetaResult(gameState.getScore(), gameState);
		}
		if (maximizingPlayer) {
			v = Integer.MIN_VALUE;
			GameState bestChild = null;
			List<GameState> posFutures = gameState.getPosFutures(pilot,maximizingPlayer);
			if (posFutures.size()==0) {
				return new AlphaBetaResult(0, gameState);
			}
			if (posFutures.size()==1)
			{
				return new AlphaBetaResult(0, posFutures.get(0));
			}
			for (GameState child : posFutures) {

				//Look deeper if considering corner
				double score = alphabeta(child, depth - 1, alphaBound, betaBound, false,
						pilot).getValue();
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
			GameState bestChild = null;
			List<GameState> posFutures = gameState.getPosFutures(pilot,maximizingPlayer);
			if (posFutures.size()==0) {
				return new AlphaBetaResult(0, gameState);
			}
			if (posFutures.size()==1)
			{
				return new AlphaBetaResult(0, posFutures.get(0));
			}
			
			
			for (GameState child : posFutures) {
				
				double score = alphabeta(child, depth - 1, alphaBound, betaBound, true,
						pilot).getValue();
				
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

	private double min(double v, double alphabeta) {

		if (v < alphabeta) {
			return v;
		}

		return alphabeta;
	}

	private double max(double v, double alphabeta) {
		if (v > alphabeta) {
			return v;
		}
		return alphabeta;
	}
}