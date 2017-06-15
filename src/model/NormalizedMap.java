package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NormalizedMap implements INormalizedMap {

	
	private static final int MapSize = 200;
	private List<EnemyPosition> enemies = new ArrayList<EnemyPosition>();
	private List<Boundaries> bounds = new ArrayList<Boundaries>();
	private List<Base> bases;

	public NormalizedMap(IPosition fighter, HashMap<Integer, IPosition> pilots2Position, HashMap<Integer, IPosition> bounds2Positions, HashMap<Integer, IPosition> antiAir2Positions, HashMap<Integer, IPosition> base2position, Map<Integer, Integer> base2Fighters) {
		
		//Transformation of positions
		
		for (Entry<Integer,IPosition> entry: pilots2Position.entrySet())
		{
			if (fighter.getId()!=entry.getKey())
			{
				IPosition normPos = normalizePosition(fighter,entry.getValue(),entry.getKey());
				enemies.add(new EnemyPosition(normPos));
			}
		}
		// Design change on Boundaries. One square for the root corner the boundaries. the square is formed around the one corner
		for (Entry<Integer,IPosition> entry: bounds2Positions.entrySet())
		{
			
		
			
			int boundX = entry.getValue().getCoord()[0];
			int boundY= entry.getValue().getCoord()[1];
				
				for (int i = 0; i< MapSize; i++)
				{

					IPosition normPos = normalizePosition(fighter,entry.getValue(),entry.getKey());
				
					bounds.add(new Boundaries(normPos));
					
					//System.out.println(i);
					final int inc = i;
					//IPosition normPos2 = normalizePosition(fighter,entry.getValue(),entry.getKey());
					bounds.add(new Boundaries( normalizePosition(fighter,new IPosition() {
						
						@Override
						public int getId() {
						
							return entry.getKey();
						}
						
						@Override
						public double getDirection() {
							
							return 0;
						}
						
						@Override
						public int[] getCoord() {
							
							return new int[]{boundX,boundY+inc};
						}
					}, entry.getKey())));
					
					bounds.add(new Boundaries( normalizePosition(fighter,new IPosition() {
						
						@Override
						public int getId() {
						
							return entry.getKey();
						}
						
						@Override
						public double getDirection() {
							
							return 0;
						}
						
						@Override
						public int[] getCoord() {
							
							return new int[]{boundX+MapSize,boundY+inc};
						}
					}, entry.getKey())));
					bounds.add(new Boundaries( normalizePosition(fighter,new IPosition() {
						
						@Override
						public int getId() {
						
							return entry.getKey();
						}
						
						@Override
						public double getDirection() {
							
							return 0;
						}
						
						@Override
						public int[] getCoord() {
							
							return new int[]{boundX+inc,boundY};
						}
					}, entry.getKey())));
					bounds.add(new Boundaries( normalizePosition(fighter,new IPosition() {
						
						@Override
						public int getId() {
						
							return entry.getKey();
						}
						
						@Override
						public double getDirection() {
							
							return 0;
						}
						
						@Override
						public int[] getCoord() {
							
							return new int[]{boundX+inc,boundY+MapSize};
						}
					}, entry.getKey())));
					

				}
				
		}
		
		for (Entry<Integer,IPosition> entry: base2position.entrySet())
		{
			
				IPosition normPos = normalizePosition(fighter,entry.getValue(),entry.getKey());
				bases.add(new Base(normPos));
		}
		
		
	}

	protected IPosition normalizePosition(IPosition fighter, IPosition enemy, Integer id) {
		
		double theta = fighter.getDirection();
		
		double globalX = enemy.getCoord()[0];
		double globalY = enemy.getCoord()[1];
		
		//translate
		globalX -= fighter.getCoord()[0];
		globalY -= fighter.getCoord()[1];
		
		double normX =globalX *Math.cos(theta)+ globalY* Math.sin(theta);
		double normY = -1.0 *globalX *Math.sin(theta)+ globalY* Math.cos(theta);
		//System.out.println("Normalized X: " + normX);
		return new Position(normX * -1.0,normY,id);
	}

	@Override
	public List<EnemyPosition> getEnemies() {
		return enemies ;
	}

	@Override
	public List<Boundaries> getBounds() {
		return bounds ;
	}

	@Override
	public List<Base> getBases() {
		return bases;
	}

	@Override
	public List<Obstical> getObsticals() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
	double dimen = 80;
	char[][] map = new char[(int) dimen][(int) dimen];
	int center = (int) (dimen/2.0);
	map[center][center] = 'P';
	
	for (EnemyPosition en: enemies)
	{
		if (isOnMap(en,center))
		{
			int screenX = (int)(en.getCoord()[0]+ center);
			int screenY = (int) (en.getCoord()[1]+ center);
			map[screenX][screenY] = 'e';
		}
	}
	
	for (Boundaries en: bounds)
	{
		//System.out.println("Boundary Considered");
		if (isOnMap(en,center))
		{
			int screenX = (int)(en.getCoord()[0]+ center);
			int screenY = (int) (en.getCoord()[1]+ center);
			//System.out.println("Boundary Drawn");
			map[screenX][screenY] = 'B';
		}
	}
	
	StringBuilder sb = new StringBuilder();
	for (int j = 0; j<dimen; j++)
		{
		for (int i = 0; i<dimen; i++)
			{
				if (map[i][j]==0)
				{
					sb.append(" - ");
				}
				else
				{
					sb.append(" ").append(map[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		
		
		return sb.toString();
	}

	private boolean isOnMap(IPosition en, int center) {
		//System.out.println(Arrays.toString(en.getCoord()));
		return Math.abs(en.getCoord()[0])<center
				&&  Math.abs(en.getCoord()[1])<center;
	}

	
}
