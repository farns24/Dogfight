package Conditions;

import java.util.List;

import model.Base;
import model.Boundaries;
import model.EnemyPosition;
import model.Obstical;

public class ConditionFinder {


	
	public Conditions getConditions(List<EnemyPosition> enemies,
			List<Boundaries> bounds, List<Base> bases, List<Obstical> obsticals) {
		Conditions cond = new Conditions();
		
		for (Boundaries bound: bounds)
		{
			if(isInFront(bound.getCoord()))
			{
				cond.setAPPROACHINGOBSTACLE(true);
			}
			else if (isToLeft(bound.getCoord()))
			{
				cond.setObsticalToLeft(true);
			}
			else if (isToRight(bound.getCoord()))
			{
				cond.setObsticalToRight(true);
			}
		}
		
		for (EnemyPosition enemy: enemies)
		{
			if(isInFront(enemy.getCoord()))
			{
				cond.setENEMYINSIGHTS(true);
			}
			else if (isToLeft(enemy.getCoord()))
			{
				cond.setENEMYToLeft(true);
			}
			else if (isToRight(enemy.getCoord()))
			{
				cond.setEnemyToRight(true);
			}
			else if (isBehind(enemy.getCoord()))
			{
				cond.setINENEMYSIGHTS(true);
			}
		}
		
		return cond;
	}
	
	
	
	private boolean isBehind(int[] coord) {
		return coord[1]>0 && coord[1]<10 && Math.abs(coord[0])<5;
	}



	private boolean isToRight(int[] coord) {
		
		return coord[1]>-15 && coord[1]<5 && coord[0]>5 && coord[0]<10;
	}



	private boolean isToLeft(int[] coord) {
		
		return coord[1]>-15 && coord[1]<5 && coord[0]<-5 && coord[0]>-10;
	}



	private boolean isInFront(int[] coord) {
		
		return coord[1]<0 && coord[1]>-10 && Math.abs(coord[0])<5;
	}
		
		
		
		
		
	

}
