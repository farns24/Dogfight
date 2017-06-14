package alpha_beta;

import model.decisions.GameState;

public class AlphaBetaResult {

	private double value;
	private GameState gameState;
	public double getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public GameState getGameState() {
		return gameState;
	}
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	public AlphaBetaResult(double value, GameState gameState) {
		super();
		this.value = value;
		this.gameState = gameState;
	}
	
}
