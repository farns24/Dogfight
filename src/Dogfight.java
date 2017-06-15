import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import telnet.TaskException;
import telnet.TelnetProxy;
import model.BattleField;
import model.FlightSchoolField;
import model.LocationScape;

/**
 * Created by michael on 6/14/17.
 */
public class Dogfight {
    public static void main(String[] args) {
        System.out.println("Under Construction\n");
        
        Set<Integer> fighterIds = new TreeSet<Integer>();
        fighterIds.add(5);
		Set<Integer> boundaryIds = new TreeSet<Integer>();
		boundaryIds.add(78);
		boundaryIds.add(26);
		boundaryIds.add(75);
		boundaryIds.add(94);
		
		Set<Integer> antiAircraftIds = new TreeSet<Integer>();
		Map<Integer, Integer> baseId2FighterIdMap = new HashMap<Integer, Integer>();
		BattleField field = new FlightSchoolField(fighterIds, boundaryIds, antiAircraftIds, baseId2FighterIdMap);
        
		TelnetProxy proxy = new TelnetProxy();
		try {
			proxy.connectToBot();
	
		
		//while (true){
			
			LocationScape map = proxy.where();
			field.updateBattleField(map);
			
		//	}
		} catch (TaskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
