package actors;

import game.ZombieGameObject;
import event.ZombieEvent;
import util.ActionType;

public class Survivor extends ZombieGameObject {

    public void attack() {
        System.out.println("Survivor: Player is Attacking!");
        this.fireEvent(ActionType.PLAYER_ATTACK);
    }

    public void move() {
        System.out.println("Survivor: Player is Moving!");
        this.fireEvent(ActionType.PLAYER_MOVE);
    }

    @Override
    public void messageReceived(ZombieEvent _event) {
        // Analyze the event type.
        int message = _event.getMessage().getMessage();
        switch (message) {
            case ActionType.ZOMBIE_MOVE:
                System.out.println("Survivor: The Player sees the zombie move!");
                break;
            case ActionType.ZOMBIE_ATTACK:
                System.out.println("Survivor: The Player is being attacked.");
                break;
        }
    }

}
