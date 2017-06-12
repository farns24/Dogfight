package model;

import java.util.Map;
import java.util.Set;

public class FlightSchoolField extends BattleField {

	public FlightSchoolField(Set<Integer> fighterIds, Set<Integer> boundaryIds, Set<Integer> antiAircraftIds,
			Map<Integer, Integer> baseId2FighterIdMap) {
		super(fighterIds, boundaryIds, antiAircraftIds, baseId2FighterIdMap);
		
	}

}
