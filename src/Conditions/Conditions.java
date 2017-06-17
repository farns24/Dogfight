package Conditions;

/**
 * Created by michael on 6/14/17.
 */
public class Conditions {
    private boolean ENEMYINSIGHTS;
    private boolean INENEMYSIGHTS;
    private boolean SEARCHING;
    private boolean OUTOFAMMO;
    private boolean OUTOFFUEL;
    private boolean APPROACHINGOBSTACLE;
	private boolean OBSTICALTORIGHT;
	private boolean OBSTICALTOLEFT;
	private boolean ENEMYTOLEFT;
	private boolean ENEMYTORIGHT;

    public Conditions(boolean ENEMYINSIGHTS, boolean INENEMYSIGHTS, boolean SEARCHING, boolean OUTOFAMMO,
                      boolean OUTOFFUEL, boolean APPROACHINGOBSTACLE, boolean OBSTICALTORIGHT, boolean OBSTICALTOLEFT,
                      boolean ENEMYTOLEFT, boolean ENEMYTORIGHT) {
        this.ENEMYINSIGHTS = ENEMYINSIGHTS;
        this.INENEMYSIGHTS = INENEMYSIGHTS;
        this.SEARCHING = SEARCHING;
        this.OUTOFAMMO = OUTOFAMMO;
        this.OUTOFFUEL = OUTOFFUEL;
        this.APPROACHINGOBSTACLE = APPROACHINGOBSTACLE;
        this.OBSTICALTORIGHT = OBSTICALTORIGHT;
        this.OBSTICALTOLEFT = OBSTICALTOLEFT;
        this.ENEMYTOLEFT = ENEMYTOLEFT;
        this.ENEMYTORIGHT = ENEMYTORIGHT;
    }

    public Conditions() {
        this.ENEMYINSIGHTS = false;
        this.INENEMYSIGHTS = false;
        this.SEARCHING = false;
        this.OUTOFAMMO = false;
        this.OUTOFFUEL = false;
        this.APPROACHINGOBSTACLE = false;
        this.OBSTICALTORIGHT = false;
        this.OBSTICALTOLEFT = false;
        this.ENEMYTOLEFT = false;
        this.ENEMYTORIGHT = false;
    }

    public boolean ENEMYINSIGHTS() {
        return ENEMYINSIGHTS;
    }

    public void setENEMYINSIGHTS(boolean ENEMYINSIGHTS) {
        this.ENEMYINSIGHTS = ENEMYINSIGHTS;
    }

    public boolean INENEMYSIGHTS() {
        return INENEMYSIGHTS;
    }

    public void setINENEMYSIGHTS(boolean INENEMYSIGHTS) {
        this.INENEMYSIGHTS = INENEMYSIGHTS;
    }

    public boolean SEARCHING() {
        return SEARCHING;
    }

    public void setSEARCHING(boolean SEARCHING) {
        this.SEARCHING = SEARCHING;
    }

    public boolean OUTOFAMMO() {
        return OUTOFAMMO;
    }

    public void setOUTOFAMMO(boolean OUTOFAMMO) {
        this.OUTOFAMMO = OUTOFAMMO;
    }

    public boolean OUTOFFUEL() {
        return OUTOFFUEL;
    }

    public void setOUTOFFUEL(boolean OUTOFFUEL) {
        this.OUTOFFUEL = OUTOFFUEL;
    }

    public boolean APPROACHINGOBSTACLE() {
        return APPROACHINGOBSTACLE;
    }

    public void setAPPROACHINGOBSTACLE(boolean APPROACHINGOBSTACLE) {
        this.APPROACHINGOBSTACLE = APPROACHINGOBSTACLE;
    }

	public void setObsticalToRight(boolean b) {
		this.OBSTICALTORIGHT = b;

	}

	public void setObsticalToLeft(boolean b) {
		this.OBSTICALTOLEFT = b;

	}

	public void setENEMYToLeft(boolean b) {
		this.ENEMYTOLEFT = b;

	}

	public void setEnemyToRight(boolean b) {
		this.ENEMYTORIGHT = b;

	}

    public boolean OBSTICALTORIGHT() {
        return OBSTICALTORIGHT;
    }

    public boolean OBSTICALTOLEFT() {
        return OBSTICALTOLEFT;
    }

    public boolean ENEMYTOLEFT() {
        return ENEMYTOLEFT;
    }

    public boolean ENEMYTORIGHT() {
        return ENEMYTORIGHT;
    }

    public boolean somethingNearby() {
        return ENEMYINSIGHTS || INENEMYSIGHTS || APPROACHINGOBSTACLE || OBSTICALTOLEFT || OBSTICALTORIGHT ||
                ENEMYTOLEFT || ENEMYTORIGHT;
    }
}
