package model;

public class Enemy {
    boolean isAlive;

    public Enemy() {
        isAlive = true;
    }

    public void die() {
        isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
