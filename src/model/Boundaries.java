package model;

public class Boundaries implements IPosition {

	private IPosition pos;

	public Boundaries(IPosition normPos) {
		this.pos = normPos;
	}

	@Override
	public int getId() {
		return pos.getId();
	}

	@Override
	public int[] getCoord() {
		return pos.getCoord();
	}

	@Override
	public double getDirection() {
		return 0.0;
	}

}
