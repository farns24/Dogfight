package potentialFields;

import java.util.ArrayList;
import java.util.List;

import model.EnemyPosition;
import model.IBiplane;
import model.LocationScape;
import model.OutOfFuelException;
import model.RobotLocation;

public class PotentialFieldFinder implements IPotentialFields {

	@Override
	public void search(IBiplane plane, List<EnemyPosition> enemies) {
		int height=400;
		int width=400;
		ArrayList<PotentialField> fields = new ArrayList<PotentialField>();
		
		LocationScape map = plane.getRadar();
		//aF.printArrows();
		for (String key :map.keySet())
		{
			RobotLocation loc = map.get(key);
			
			if (key.equals("robot") || key.equals("5"))
			{
				continue;	//Ignore robot and goal markers
			}
			AttractionField rF = new AttractionField(loc.getCenter(), height, width);	//Add obstacles
			//rF.printArrows();
			fields.add(rF);
		}
		
		CompositeField field = new CompositeField(height, width, fields);
		
		
		//field.printArrows();
		
		RobotLocation rob = plane.getRadar().get("5");
		
		int[] vect = rob.getPFVector(field);
		
		double direction = Math.atan2(vect[0], vect[1]);
		
		try {
			if (direction<0)
			{
				plane.turnRight(1);
			}
			else if(direction>0)
			{
				plane.turnLeft(1);
			}
			else
			{
				plane.goForward(3);
			}
		} catch (OutOfFuelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
