package game;

import actors.Survivor;
import actors.Zombie;
import actors.ZombieGameObject;
import event.ZombieEvent;
import util.ActionType;

public class ZombieGameBoard extends ZombieGameObject{

    private final Survivor survivor;
    private final Zombie zombie;

    public ZombieGameBoard() {
        System.out.println("ZombieGameBoard: A game board has been created.");
        this.survivor = new Survivor();
        this.zombie = new Zombie();
    }

    public void initializeGame() {
        System.out.println("ZombieGameBoard: A New Game has been initialzied.");
        // The zombies are going to listen for surivor events.
        this.survivor.addSRegisterListener(zombie);
        System.out.println("ZombieGameBoard: Zombie is now listening for survivor events.");
        // The game will listen for both zombie and surivor events and bubble them up the chain.
        this.survivor.addSRegisterListener(this);
        this.zombie.addSRegisterListener(this);
        // Throw an event signifying that the game is ready.
        this.fireEvent(ActionType.START_NEW_GAME);
    }

    public void playerAttacks() {
        this.survivor.attack();
    }

    public void playerMoves() {
        this.survivor.move();
    }

    @Override
    public void messageReceived(ZombieEvent event) {
        // Just pass along the fired event.
        this.fireEvent(event);
    }

}
