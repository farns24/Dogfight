package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import callback.BiplaneEventListener;

import java.util.Set;

public abstract class BattleField  implements IBattleField{

	protected Set<Integer> figherIds;
	protected Set<Integer> boundaryIds;
	protected Set<Integer> antiAircraftIds;
	protected Map<Integer, Integer> base2Fighters;
	protected Map<Integer,Pilot> pilots;
	private HashMap<Integer, IPosition> pilots2Position;
	private HashMap<Integer, IPosition> bounds2Positions;
	private HashMap<Integer, IPosition> antiAir2Positions;
	private HashMap<Integer, IPosition> base2position;

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
		this.pilots2Position = new HashMap<Integer,IPosition>();
		bounds2Positions = new HashMap<Integer, IPosition>();
		antiAir2Positions = new HashMap<Integer, IPosition>();
		base2position = new HashMap<Integer, IPosition>();
		
		//Initialize pilots
		for (Integer pilotId: fighterIds)
		{
			pilots.put(pilotId, new BritishPilot(new FlightSimulator()));//SopwithCamel()));
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
				pilots2Position.put(pos.getId(), pos);
				continue;
				
			}
			else if (boundaryIds.contains(pos.getId()))
			{
				//add to Boundaries
				bounds2Positions.put(pos.getId(),pos);
				continue;
			}
			else if (antiAircraftIds.contains(pos.getId()))
			{
				antiAir2Positions.put(pos.getId(),pos);
				continue;
			}
			else if (base2Fighters.keySet().contains(pos.getId()))
			{
				base2position.put(pos.getId(),pos);
				continue;
			}
			else
			{
				continue;
				//Add boundary
			}
			
		}
		
		//Update pilots
		
			for (Entry<Integer,Pilot> entry :pilots.entrySet())
			{
				INormalizedMap normMap;
				try {
					Pilot p = entry.getValue();
					
					IPosition fighter = pilots2Position.get(entry.getKey());
					
					
					normMap = new NormalizedMap(fighter,pilots2Position, bounds2Positions,antiAir2Positions,base2position,base2Fighters);
					//Build normalized Map
					entry.getValue().respondToEnvironment(normMap, new BiplaneEventListener() {
						
						@Override
						public void onFire(Set<IRound> shotsFired) {
							// TODO Auto-generated method stub
							
						}
					});

					System.out.println(normMap.toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
		
	}
	
}
