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
		
		location.put("6", new RobotLocation(new double[4][2],new double[]{0,1},new double[]{250,200}));
		
		location.put("23", new RobotLocation(new double[4][2],new double[]{0,1},new double[]{0,0}));
			
	}
	

	public void speed(double speed, double speed2, String id) {
		
		if (speed==speed2)
		{
			moveForward(speed,speed2,id);
		}
		else if (speed<speed2)
		{
			moveLeft(speed,speed2,id);
		}
		else
		{
			moveRight(speed,speed2,id);
			
		}
	}
	private void moveRight(double speed, double speed2, String id) {

		RobotLocation fighter = location.get(id);
		
		double deltaSpeed = speed - speed2;
		int dSpeed = (int) deltaSpeed;
		
		
		double averageSpeed = (speed+speed2)/2.0;
		
		double dtheta = deltaSpeed * Math.PI/12;//Math.atan2(speed,deltaSpeed);
		dtheta /=2.0;
		double newTheta =  fighter.getOrientation()- dtheta;
		//if(deltaSpeed!=0)
		newTheta+=Math.PI;
		System.out.println(newTheta);
		if (dSpeed==0 || (dSpeed!=0 &&newTheta>Math.PI/2.0 &&newTheta<Math.PI)||(dSpeed!=0 &&newTheta>3.0*Math.PI/2.0&&newTheta<2.0 * Math.PI ))
		{
			averageSpeed*=-1;
		}
		double dx = averageSpeed * Math.sin(newTheta);
		double dy = averageSpeed * Math.cos(newTheta);
		
		int[] newcoord = fighter.getCenter();
		newcoord[0]+=dx;
		newcoord[1]+=dy;
		
		fighter.setCenter(newcoord);
		double sine = Math.sin(newTheta);
		//if (deltaSpeed!=0)
		{
			sine*= -1.0;
		}
		
		fighter.setOrientation(new double[]{Math.cos(newTheta),sine});
		location.put(id, fighter);

		
	}

	private void moveLeft(double speed, double speed2, String id) {

		RobotLocation fighter = location.get(id);
		
		double deltaSpeed = speed - speed2;
		int dSpeed = (int) deltaSpeed;
		
		
		double averageSpeed = (speed+speed2)/2.0;
		
		double dtheta = deltaSpeed * Math.PI/12;//Math.atan2(speed,deltaSpeed);
		dtheta /=2.0;
		double newTheta =  fighter.getOrientation()- dtheta;
		//if(deltaSpeed!=0)
		newTheta+=Math.PI;
		
		//(dSpeed!=0 &&newTheta>3.0*Math.PI/2.0 &&newTheta>2.0 *Math.PI)
		if (dSpeed==0 || (dSpeed!=0 &&newTheta>0 &&newTheta<Math.PI/2.0)||(dSpeed!=0 &&newTheta>Math.PI&&newTheta<3.0*Math.PI/2.0 ))
		{
			averageSpeed*=-1;
		}
		double dx = averageSpeed * Math.sin(newTheta);
		double dy = averageSpeed * Math.cos(newTheta);
		
		int[] newcoord = fighter.getCenter();
		newcoord[0]+=dx;
		newcoord[1]+=dy;
		
		fighter.setCenter(newcoord);
		double sine = Math.sin(newTheta);
		//if (deltaSpeed!=0)
		{
			sine*= -1.0;
		}
		
		fighter.setOrientation(new double[]{Math.cos(newTheta),sine});
		location.put(id, fighter);

		
	}

	private void moveForward(double speed, double speed2, String id) {

		RobotLocation fighter = location.get(id);
		
		double deltaSpeed = speed - speed2;
		int dSpeed = (int) deltaSpeed;
		
		
		double averageSpeed = (speed+speed2)/2.0;
		
		double dtheta = deltaSpeed * Math.PI/12;//Math.atan2(speed,deltaSpeed);
		dtheta /=2.0;
		double newTheta =  fighter.getOrientation()- dtheta;
		//if(deltaSpeed!=0)
		newTheta+=Math.PI;
		
		if (dSpeed<=0 && newTheta>=(3.0*Math.PI/2.0))
		{
			averageSpeed*=-1;
		}
		double dx = averageSpeed * Math.sin(newTheta);
		double dy = averageSpeed * Math.cos(newTheta);
		
		int[] newcoord = fighter.getCenter();
		newcoord[0]+=dx;
		newcoord[1]+=dy;
		
		fighter.setCenter(newcoord);
		double sine = Math.sin(newTheta);
		//if (deltaSpeed!=0)
		{
			sine*= -1.0;
		}
		
		fighter.setOrientation(new double[]{Math.cos(newTheta),sine});
		location.put(id, fighter);

		
	}

	public LocationScape where()
	{
		return location;
	}

	public void connectToBot() {
		// TODO Auto-generated method stub
		
	}
	
	

}
