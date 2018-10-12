/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Ike
 */
public class CombatTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        runCombatTest();
    }
    
    public static void runCombatTest() {
        // Build Test Array
        CombatTestData.runTest(1,  2,  83.3);
        CombatTestData.runTest(1,  6,  16.7);
        CombatTestData.runTest(1,  7,     0);
        CombatTestData.runTest(3,  5,  99.7);
        CombatTestData.runTest(3,  6,  94.9);
        CombatTestData.runTest(3,  9,  74.1);
        CombatTestData.runTest(9,  2, 100.0);
        CombatTestData.runTest(9, 12, 100.0);
    }
    
    

}
