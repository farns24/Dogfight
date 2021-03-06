import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import telnet.TaskException;
import telnet.TelnetProxy;
import model.BattleField;
import model.FlightSchoolField;
import model.FlightSimulatorEngine;
import model.LocationScape;

/**
 * Created by michael on 6/14/17.
 */
public class Dogfight {
    public static void main(String[] args) {
        System.out.println("Under Construction\n");
        
        Set<Integer> fighterIds = new TreeSet<Integer>();
        fighterIds.add(5);
        fighterIds.add(6);
		Set<Integer> boundaryIds = new TreeSet<Integer>();
		boundaryIds.add(23);
		
		Set<Integer> antiAircraftIds = new TreeSet<Integer>();
		Map<Integer, Integer> baseId2FighterIdMap = new HashMap<Integer, Integer>();
		BattleField field = new FlightSchoolField(fighterIds, boundaryIds, antiAircraftIds, baseId2FighterIdMap);
        
		//TelnetProxy proxy = new TelnetProxy();
		FlightSimulatorEngine proxy = FlightSimulatorEngine.getInstance();
		try {
			proxy.connectToBot();
	
		
		while (true){
			
			LocationScape map = proxy.where();
			field.updateBattleField(map);
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
