package potentialFields;

import model.EnemyPosition;
import model.IBiplane;

import java.util.List;

/**
 * Created by michael on 6/17/17.
 */
public interface IPotentialFields {
    void search(IBiplane plane, List<EnemyPosition> enemies);
}
