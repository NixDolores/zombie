package combat;

import java.util.Random;

/**
 * @author Ike
 */
public class CombatTemp {

    private static int[][] oneHit;
    private static int[][] twoHit;
    private static int[][] threeHit;
    private static final Random random = new Random();

    public static int resolveHits(int _attack, int _defense) {
        if (CombatTemp.oneHit == null) {
            CombatTemp.buildOneHitTable();
        }
        if (CombatTemp.twoHit == null) {
            CombatTemp.buildTwoHitTable();
        }
        if (CombatTemp.threeHit == null) {
            CombatTemp.buildThreeHitTable();
        }
        if (CombatTemp.threeHitChecker(_attack, _defense)) {
            return 3;
        } else if (CombatTemp.twoHitChecker(_attack, _defense)) {
            return 2;
        } else if (CombatTemp.oneHitChecker(_attack, _defense)) {
            return 1;
        }
        return 0;
    }

    private static Boolean threeHitChecker(int _attack, int _defense) {
        int target = CombatTemp.threeHit[_attack][_defense];
        int roll = CombatTemp.getRandom();
        return (roll <= target);
    }

    private static Boolean twoHitChecker(int _attack, int _defense) {
        int target = CombatTemp.twoHit[_attack][_defense];
        int roll = CombatTemp.getRandom();
        return (roll <= target);
    }

    private static Boolean oneHitChecker(int _attack, int _defense) {
        int target = CombatTemp.oneHit[_attack][_defense];
        int roll = CombatTemp.getRandom();
        return (roll <= target);
    }

    private static void buildOneHitTable() {
        CombatTemp.oneHit = new int[][]{
            { 833,  667,  500,  333,  167,    0,    0,    0,    0,    0,    0},
            {1000,  972,  917,  833,  722,  583,  417,  278,  167,   83,   28},
            {1000,  995,  991,  997,  949,  903,  833,  741,  625,   50,  375},
            {1000, 1000,  999,  998,  994,  985,  969,  941,  899,  838,  758},
            {1000, 1000, 1000, 1000,  999,  998,  996,  991,  981,  946,  938},
            {1000, 1000, 1000, 1000, 1000, 1000, 1000,  999,  997,  994,  998},
            {1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,  999,  998},
            {1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000},
            {1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000}
        };
    }

    private static void buildTwoHitTable() {
        CombatTemp.twoHit = new int[][]{
            {   0,    0,    0,    0,    0,    0,    0,    0,    0,    0,    0},
            { 694,  444,  250,  111,   28,    0,    0,    0,    0,    0,    0},
            { 972,  907,  750,  537,  282,    0,    0,    0,    0,    0,    0},
            { 999,  989,  961,  883,  737,  479,  252,   11,   39,    8,    1},
            {1000,  999,  995,  977,  928,  813,  619,  398,  214,   84,   23},
            {1000, 1000,  999,  997,  986,  951,  869,  716,  513,  298,   14},
            {1000, 1000, 1000, 1000,  998,  991,  970,  915,  813,  655,  473},
            {1000, 1000, 1000, 1000, 1000,  999,  994,  980,  945,  874,  760},
            {1000, 1000, 1000, 1000, 1000, 1000,  999,  996,  987,  963,  913}
        };
    }

    private static void buildThreeHitTable() {
        CombatTemp.threeHit = new int[][]{
            {   0,    0,    0,    0,    0,    0,    0,    0,    0,    0,    0},
            {   0,    0,    0,    0,    0,    0,    0,    0,    0,    0,    0},
            { 579,  296,  125,   37,    5,    0,    0,    0,    0,    0,    0},
            { 965,  815,  563,  296,   86,    0,    0,    0,    0,    0,    0},
            { 998,  975,  893,  696,  393,    0,    0,    0,    0,    0,    0},
            {1000,  998,  982,  916,  760,  459,  165,   46,    9,    1,    0},
            {1000, 1000,  998,  982,  923,  750,  487,  233,   83,   17,    1},
            {1000, 1000, 1000,  997,  981,  907,  729,  455,   22,   59,    9},
            {1000, 1000, 1000, 1000,  996,  975,  901,  707,  446,  183,   57}
        };
    }

    private static int getRandom() {
        return CombatTemp.random.nextInt(1000) + 1;
    }

}
