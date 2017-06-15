package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class LocationScape extends HashMap<String,RobotLocation> implements IRawBattleMap{
	private double time;

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	@Override
	public Collection<IPosition> getPositions() {
		
		Collection<IPosition> result = new ArrayList<IPosition>();
		for (Entry<String,RobotLocation> entry: this.entrySet())
		{
			int key;
			if (entry.getKey().toLowerCase().equals("robot"))
			{
				key = 5;
			}
			else
			{
				key = Integer.parseInt(entry.getKey());
			}
			
			result.add(new Position(key,entry.getValue()));
		}
		
		return result;
	}
	
}
