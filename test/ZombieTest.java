/**
 * This unit test is the main entry point for all tests to be peformed on the system.
 * Last Updated 10/16/2018
 * @author iquigley
 */
package test;

import game.ZombieGameObject;
import java.lang.reflect.InvocationTargetException;


public class ZombieTest {

    /**
     * Main static method for running this class independently of the rest of the system.
     * Uncomment whichever test you would like to perform.
     * @param args the command line arguments
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.reflect.InvocationTargetException
     * @throws java.lang.NoSuchFieldException
     */
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        // runCombatTest();
        runDataTest();
    }

    /**
     * This method creates a generic ZombieGameObject and saves it to the database.
     * Once I have satisfied myself that the ZombieGameObject works, I will make it an abstract class
     * and start building my actual ZombieGameObjects such as Zombies, Survivors, Cannibals... etc.
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchFieldException
     */
    public static void runDataTest() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        // Create a DataObject and see if has a uuid.
        ZombieGameObject zombie = new ZombieGameObject();
        zombie.setAttack(1);
        zombie.setDefense(2);
        zombie.setSpeed(3);
        zombie.setYaxis(4);
        zombie.setXaxis(5);
        zombie.setZaxis(6);
        zombie.setHeight(200);
        zombie.setWidth(100);
        zombie.setName("Test Zombie");
        System.out.println("Zombie Uuid: " + zombie.getUuid());
        zombie.save();
    }

    /**
     * Runs a combat test to check to make sure we're loading the right percentages.
     * Uses the helper class CombatTestData.
     */
    public static void runCombatTest() {
        // Build Test Array for 1 hit.
        System.out.println("1 Hit Tests.");
        CombatTestData.runTest(1,  2,  83.3, 1);
        CombatTestData.runTest(1,  6,  16.7, 1);
        CombatTestData.runTest(1,  7,     0, 1);
        CombatTestData.runTest(3,  5,  99.7, 1);
        CombatTestData.runTest(3,  6,  94.9, 1);
        CombatTestData.runTest(3,  9,  74.1, 1);
        CombatTestData.runTest(9,  2, 100.0, 1);
        CombatTestData.runTest(9, 12, 100.0, 1);

        // Build Test Array for 2 hit.
        System.out.println("2 Hit Tests.");
        CombatTestData.runTest(1,  2,     0, 2);
        CombatTestData.runTest(1,  6,     0, 2);
        CombatTestData.runTest(2,  2,  69.4, 2);
        CombatTestData.runTest(2,  6,   2.8, 2);
        CombatTestData.runTest(2,  7,     0, 2);
        CombatTestData.runTest(2, 12,     0, 2);
        CombatTestData.runTest(4,  2,  99.9, 2);
        CombatTestData.runTest(4, 6,   73.7, 2);
        CombatTestData.runTest(4, 12,     1, 2);
        CombatTestData.runTest(8,  2,   100, 2);
        CombatTestData.runTest(8, 10,  94.5, 2);
        CombatTestData.runTest(9,  7,   100, 2);
        CombatTestData.runTest(9,  8,  99.9, 2);
        CombatTestData.runTest(9, 12,  91.3, 2);

        // Build Test Array for 3 hit
        System.out.println("3 Hit Tests.");
        CombatTestData.runTest(1,  2,     0, 3);
        CombatTestData.runTest(2, 12,     0, 3);
        CombatTestData.runTest(3,  2,  57.9, 3);
        CombatTestData.runTest(3,  6,   0.5, 3);
        CombatTestData.runTest(5,  2,  99.8, 3);
        CombatTestData.runTest(5,  6,  39.3, 3);
        CombatTestData.runTest(5,  7,     0, 3);
        CombatTestData.runTest(9,  2, 100.0, 3);
        CombatTestData.runTest(9,  5, 100.0, 3);
        CombatTestData.runTest(9,  6,  99.6, 3);
        CombatTestData.runTest(9, 12,   5.7, 3);

    }

}
