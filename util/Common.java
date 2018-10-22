package util;

import java.util.Random;

/**
 * A collection of useful methods.
 * @author Ike
 */
public class Common {

    private static final Random random = new Random();

    public static int getRandom(int max) {
        return random.nextInt(max) + 1;
    }

}
