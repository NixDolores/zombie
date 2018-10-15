/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

import game.ZombieGameObject;
import event.ZombieEvent;
import util.ActionType;

/**
 *
 * @author Ike
 */
public class Zombie extends ZombieGameObject {

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
