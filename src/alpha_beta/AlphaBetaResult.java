package alpha_beta;

import model.decisions.Decider;

public class AlphaBetaResult {

	private int value;
	private Decider decider;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Decider getDecider() {
		return decider;
	}
	public void setDecider(Decider decider) {
		this.decider = decider;
	}
	public AlphaBetaResult(int value, Decider decider) {
		super();
		this.value = value;
		this.decider = decider;
	}
	
}
