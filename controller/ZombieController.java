package controller;


import event.ZombieEventListenerInterface;
import game.ZombieGameBoard;
import util.ActionType;

public class ZombieController {

    protected static ZombieGameBoard game;


    public static void reactToInput(Integer _choice) {
        switch(_choice) {
            case ActionType.START_NEW_GAME:
                ZombieController.game = new ZombieGameBoard();
                break;
            case ActionType.PLAYER_ATTACK:
                ZombieController.game.playerAttacks();
                break;
            case ActionType.PLAYER_MOVE:
                ZombieController.game.playerMoves();
                break;
            default:
                System.out.println("ZombieController: Unknown player entry.");
                break;
        }
    }

    public static void registerView(ZombieEventListenerInterface _view) {
        ZombieController.game.addSRegisterListener(_view);
        System.out.println("ZombieController: The View is now listening for Game Events.");
        ZombieController.game.initializeGame();
    }

}
