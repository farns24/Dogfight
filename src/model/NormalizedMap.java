package model;

import java.util.List;

public class NormalizedMap implements INormalizedMap {

	public NormalizedMap(IRawBattleMap map) {
		
		for (IPosition pos: map.getPositions())
		{
			int id = pos.getId();
		}
	}
	
	@Override
	public List<Enemy> getEnemies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boundaries> getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Base> getBases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Obstical> getObsticals() {
		// TODO Auto-generated method stub
		return null;
	}

}
