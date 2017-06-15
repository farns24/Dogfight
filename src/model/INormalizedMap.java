package model;

import java.util.List;

public interface INormalizedMap {

	List<EnemyPosition> getEnemies();

	List<Boundaries> getBounds();

	List<Base> getBases();

	List<Obstical> getObsticals();

}
