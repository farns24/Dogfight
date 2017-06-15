package model;

public class Position implements IPosition {

	private int[] coord;
	private int id;
	private double dir;

	public Position(double normX, double normY, Integer id) {
		this.id = id;
		this.coord = new int[]{(int) normX,(int) normY};
		this.dir = 0;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public int[] getCoord() {
		// TODO Auto-generated method stub
		return coord;
	}

	@Override
	public double getDirection() {
		// TODO Auto-generated method stub
		return dir;
	}

}
