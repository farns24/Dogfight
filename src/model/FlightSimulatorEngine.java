package model;

public class FlightSimulatorEngine {

	private static FlightSimulatorEngine instance;
	private LocationScape location;

	public static FlightSimulatorEngine getInstance() {
		
		if (instance == null)
		{
			instance = new FlightSimulatorEngine();
		}
		
		return instance;
	}

	public FlightSimulatorEngine() {
		super();
		location = new LocationScape();
		location.put("5", new RobotLocation(new double[4][2],new double[]{0,1},new double[]{200,200}));
		location.put("79", new RobotLocation(new double[4][2],new double[]{0,1},new double[]{0,0}));
			
	}
	

	public void speed(double speed, double speed2, String id) {
		
		RobotLocation fighter = location.get(id);
		
		double deltaSpeed = speed - speed2;
		
		double averageSpeed = (speed+speed2)/2.0;
		
		double dtheta = deltaSpeed * Math.PI/12;//Math.atan2(speed,deltaSpeed);
		dtheta /=2.0;
		double newTheta =  fighter.getOrientation()- dtheta;
		
		double dx = averageSpeed * Math.sin(newTheta);
		double dy = averageSpeed * Math.cos(newTheta);
		
		int[] newcoord = fighter.getCenter();
		newcoord[0]+=dx;
		newcoord[1]+=dy;
		
		fighter.setCenter(newcoord);
		
		fighter.setOrientation(new double[]{Math.cos(newTheta),Math.sin(newTheta)});
		location.put(id, fighter);
		
	}
	public LocationScape where()
	{
		return location;
	}
	
	

}
