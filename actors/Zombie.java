package actors;

import event.ZombieEvent;
import game.ZombieGameMoveable;
import util.ActionType;

/**
 * @author Ike
 */
public class Zombie extends ZombieGameMoveable {

    public final String dataTable = "zombie_table";

    @Override
    public void messageReceived(ZombieEvent _event) {
        // Analyze the event type.
        int message = _event.getMessage().getMessage();
        switch (message) {
            case ActionType.PLAYER_MOVE:
                System.out.println("Zombie: The Zombie is now moving too!");
                break;
            case ActionType.PLAYER_ATTACK:
                System.out.println("Zombie: The Player has attacked!");
                break;
        }
    }

}
