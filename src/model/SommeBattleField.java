package model;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class SommeBattleField extends BattleField{

	public SommeBattleField(Set<Integer> fighterIds, Set<Integer> boundaryIds, Set<Integer> antiAircraftIds,
			Map<Integer, Integer> baseId2FighterIdMap) {
		super(fighterIds, boundaryIds, antiAircraftIds, baseId2FighterIdMap);
		
	}

	
	

}
