package view;

import controller.ZombieController;
import event.ZombieEvent;
import event.ZombieEventListenerInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ActionType;

public class ZombieTextInput implements ZombieEventListenerInterface{


    public void displayGame() throws IOException {
        System.out.println("The Zombie Game Started.");
        System.out.println("1. Start a new game.");
       //Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Reading data using readLine
        String choice = reader.readLine();
        if (choice.equalsIgnoreCase("1")) {
            // Register this View module with the controller.
            ZombieController.reactToInput(ActionType.START_NEW_GAME);
            ZombieController.registerView(this);
        }
    }


    @Override
    public void messageReceived(ZombieEvent _event) {
        // Analyze the event type.
        int message = _event.getMessage().getMessage();
        switch (message) {
            case ActionType.ZOMBIE_MOVE:
                System.out.println("ZombieTextInput: Display moving the zombie.");
                break;
            case ActionType.ZOMBIE_ATTACK:
                System.out.println("ZombieTextInput: Display the zombie attacks.");
                break;
            case ActionType.PLAYER_MOVE:
                System.out.println("ZombieTextInput: Display moving the player.");
                break;
            case ActionType.PLAYER_ATTACK:
                System.out.println("ZombieTextInput: Display the player attacks.");
                break;
            case ActionType.START_NEW_GAME:
                try {
                    this.displayNewGame();
                } catch (IOException ex) {
                    Logger.getLogger(ZombieTextInput.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }
    }

    public void displayNewGame() throws IOException {
        System.out.println("A ZOMBIE is nearby! Make a choice");
        //Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean endGame = false;
        while (!endGame) {
            System.out.println("1. Attack the zombie.\n2. Move Away.\n3. Quit Game.");
            // Reading data using readLine
            String choice = reader.readLine();
            if (choice.equalsIgnoreCase("1")) {
                ZombieController.reactToInput(ActionType.PLAYER_ATTACK);
            } else if (choice.equalsIgnoreCase("2")) {
                ZombieController.reactToInput(ActionType.PLAYER_MOVE);
            } else if (choice.equalsIgnoreCase("3")) {
                endGame = true;
            }
        }
    }

}
