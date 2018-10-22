package actors;

import event.ZombieEvent;
import game.ZombieGameMoveable;
import util.ActionType;

public class Survivor extends ZombieGameMoveable {

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
