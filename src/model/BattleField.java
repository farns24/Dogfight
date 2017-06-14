package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class BattleField  implements IBattleField{

	protected Set<Integer> figherIds;
	protected Set<Integer> boundaryIds;
	protected Set<Integer> antiAircraftIds;
	protected Map<Integer, Integer> base2Fighters;
	protected Map<Integer,Pilot> pilots;

	/**
	 * Each card and robot has an id associated with it. If that id is not 
	 * @param fighterIds
	 * @param boundaryIds
	 * @param antiAircraftIds
	 * @param baseId2FighterIdMap - BaseId number and the fighterId that can refuel there.
	 */
	public BattleField(Set<Integer> fighterIds,Set<Integer> boundaryIds, Set<Integer> antiAircraftIds, Map<Integer,Integer> baseId2FighterIdMap)
	{
		this.figherIds = fighterIds;
		this.boundaryIds = boundaryIds;
		this.antiAircraftIds = antiAircraftIds;
		this.base2Fighters = baseId2FighterIdMap;
		this.pilots = new HashMap<Integer,Pilot>();
		
		//Initialize pilots
		for (Integer pilotId: fighterIds)
		{
			
		}
		
		
	}
	
	@Override
	public void updateBattleField(IRawBattleMap map) {
		
		Collection<IPosition> positions = map.getPositions();
		
		for (IPosition pos : positions)
		{
			if (figherIds.contains(pos.getId()))
			{
				//Add Fighter To Map
				continue;
				
			}
			else if (boundaryIds.contains(pos.getId()))
			{
				//add to Boundaries
				continue;
			}
			else if (antiAircraftIds.contains(pos.getId()))
			{
				continue;
			}
			else if (base2Fighters.keySet().contains(pos.getId()))
			{
				continue;
			}
			else
			{
				continue;
				//Add boundary
			}
			
		}
		
		//Update pilots
		
		
		
		
	}
	
}
