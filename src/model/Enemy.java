package model;


import java.util.List;

public class Enemy extends Pilot {

    public Enemy(IBiplane plane) {
        super(plane);
    }

	@Override
	public void respond(boolean isAlive, int fuelLeft, double damage, int ammoLeft, List<EnemyPosition> enemies,
			List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals) {
		// TODO Auto-generated method stub
		
	}

  
	


}
