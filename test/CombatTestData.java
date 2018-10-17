package test;

/**
 * This helper class is used to help perform combat tests.
 * The attack, defense and expected values, plus the number of hits we're testing
 * for are loaded and the average percentage of successes after N runs is reported.
 * Testers can set a tolerance level and a number of runs.
 */
import combat.Combat;

public final class CombatTestData {

    private int defense;
    private int attack;
    private final int minHits;
    private double expected;
    private double actual;

    // The acceptable tolerance, or deviation from the expected value.
    private static final double TOLERANCE = 5.0;
    // The number of runs to perform.
    private static final int RUNS = 1000;


    /**
     * Each test has an expected attack compared against a defense value.
     * @param _attack
     * @param _defense
     * @param _expected
     * @param _minHits
     */
    public CombatTestData(int _attack, int _defense, double _expected, int _minHits) {
        this.defense = _defense;
        this.attack = _attack;
        this.expected = _expected;
        this.minHits = _minHits;
        this.calcTestRun();
    }


    /**
     * This static method acts as a CombatTestData factory.
     * This prevents the calling ZombieTest class from having to create new
     * CombatTestData objects for each test.
     * @param _attack
     * @param _defense
     * @param _expected
     * @param _minHits
     */
    public static void runTest(int _attack, int _defense, double _expected, int _minHits) {
        CombatTestData ctest = new CombatTestData(_attack, _defense, _expected, _minHits);
        System.out.println(ctest.toString());
    }


    /**
     * This helper method determines if the test was a success for a failure.
     * @return String
     */
    private String getResult() {
        if (Math.abs(this.actual - this.expected) < CombatTestData.TOLERANCE) {
            return "PASS";
        }
        return "FAIL";
    }


    /**
     * The toString method formats the results of the test into a single string.
     * @return String
     */
    @Override
    public String toString() {
        return this.getResult() + " [A: " + this.attack + "  D: "
                + this.defense + "Hits: " + this.minHits
                + " Expected: " + this.expected + " Actual: " + this.actual + "]";
    }


    /**
     * Runs a test N number of times (ie. 1,000) and calculates the percentage
     * of successes and stores that value in the object property "actual."
     */
    public void calcTestRun() {
        int totalHits = 0;
        for (int i = 1; i <= CombatTestData.RUNS; i++) {
            int hits = Combat.resolveHits(this.attack, this.defense);
            if (hits >= this.minHits) {
                totalHits++;
            }
        }
        this.actual = (double)totalHits / CombatTestData.RUNS * 100;
    }

// ======================= SIMPLE GETTERS and SETTERS ==========================

    public int getDefense() {
        return defense;
    }

    public void setDefense(int _defense) {
        this.defense = _defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int _attack) {
        this.attack = _attack;
    }

    public double getExpected() {
        return expected;
    }

    public void setExpected(double _expected) {
        this.expected = _expected;
    }

    public double getActual() {
        return actual;
    }

    public void setActual(double _actual) {
        this.actual = _actual;
    }
}
