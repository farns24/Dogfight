package callback;

import java.util.Set;

import model.IRound;

public interface BiplaneEventListener {

	public void onFire(Set<IRound> shotsFired);
}
