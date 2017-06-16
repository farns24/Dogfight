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

    public Conditions(boolean ENEMYINSIGHTS, boolean INENEMYSIGHTS, boolean SEARCHING, boolean OUTOFAMMO,
                      boolean OUTOFFUEL, boolean APPROACHINGOBSTACLE) {
        this.ENEMYINSIGHTS = ENEMYINSIGHTS;
        this.INENEMYSIGHTS = INENEMYSIGHTS;
        this.SEARCHING = SEARCHING;
        this.OUTOFAMMO = OUTOFAMMO;
        this.OUTOFFUEL = OUTOFFUEL;
        this.APPROACHINGOBSTACLE = APPROACHINGOBSTACLE;
    }

    public Conditions() {
        this.ENEMYINSIGHTS = false;
        this.INENEMYSIGHTS = false;
        this.SEARCHING = false;
        this.OUTOFAMMO = false;
        this.OUTOFFUEL = false;
        this.APPROACHINGOBSTACLE = false;
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
}
