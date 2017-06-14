package alpha_beta;

import model.decisions.GameState;

public class AlphaBetaResult {

	private int value;
	private GameState gameState;
	public int getValue() {
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
	public AlphaBetaResult(int value, GameState gameState) {
		super();
		this.value = value;
		this.gameState = gameState;
	}
	
}
