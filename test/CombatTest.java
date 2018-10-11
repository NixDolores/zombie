/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import combat.Combat;


/**
 *
 * @author Ike
 */
public class CombatTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Check the odds of getting at least one hit with an attack of
        int totalHits = 0;
        for (int i = 1; i <= 1000; i++) {
            int hits = Combat.resolveHits(4, 6);
            if (hits != 0) {
                totalHits++;
            }
        }
        // Calculate Average.
        double avg = (double)totalHits / 1000;
        System.out.println("Average: " + avg);
    }
}
