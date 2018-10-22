package game;

import util.ActionType;

/**
 *
 * @author Ike
 */
public class ZombieGameMoveable extends ZombieGameObject {

    protected int attack;
    protected int defense;
    protected int speed;

    public void attack() {
        System.out.println("This Object is Attacking!");
        this.fireEvent(ActionType.PLAYER_ATTACK);
    }

    public void move() {
        System.out.println("This Object is Moving!");
        this.fireEvent(ActionType.PLAYER_MOVE);
    }

    public int getAttack() {
        return this.attack;
    }
    public int getSpeed() {
        return this.speed;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setSpeed(int _speed) {
        this.speed = _speed;
    }

    public void setDefense(int _defense) {
        this.defense = _defense;
    }

    public void setAttack(int _attack) {
        this.attack = _attack;
    }

}
