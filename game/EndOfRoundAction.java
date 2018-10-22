package game;

import util.ActionType;
import util.Common;

/**
 * At the end of each round, a 6-sided die is rolled. This die roll either determines the number
 * of zombies added to the pool, or if the zombies attack. There are four possible values
 * that can be returned, they are:
 *
 * ADD_1_TO_ZOMBIE_POOL
 * ADD_2_TO_ZOMBIE_POOL
 * ADD_3_TO_ZOMBIE_POOL
 * ZOMBIES_ATTACK
 *
 * The 6 sides of the die look like this:
 *
 * Side 1 - ADD_1_TO_ZOMBIE_POOL
 * Side 2 - ADD_2_TO_ZOMBIE_POOL
 * Side 3 - ADD_2_TO_ZOMBIE_POOL
 * Side 4 - ADD_3_TO_ZOMBIE_POOL
 * Side 5 - ADD_3_TO_ZOMBIE_POOL
 * Side 6 - ZOMBIES_ATTACK
 *
 * These values are enumerated in the ActionType class.
 * @author Ike
 */
public class EndOfRoundAction {

    public static int resolveTurn() {
        // Roll the die.
        int roll = Common.getRandom(6);
        switch (roll) {
            case 1:
                return ActionType.ADD_1_TO_ZOMBIE_POOL;
            case 2:
            case 3:
                return ActionType.ADD_2_TO_ZOMBIE_POOL;
            case 4:
            case 5:
                return ActionType.ADD_3_TO_ZOMBIE_POOL;
            default:
                return ActionType.ZOMBIE_POOL_ATTACKS;
        }
    }

}
