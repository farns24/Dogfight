package model;

public class EnemyPosition implements IPosition{
	

		IPosition position;
		public EnemyPosition(IPosition normPos) {
			position= normPos;
		}

		@Override
		public int getId() {
			return position.getId();
		}

		@Override
		public int[] getCoord() {
			return position.getCoord();
		}

		@Override
		public double getDirection() {
			return position.getDirection();
		}
}