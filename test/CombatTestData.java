package test;

import combat.Combat;

public final class CombatTestData {

    private int defense;
    private int attack;
    private double expected;
    private double actual;
    
    private static final double TOLERANCE = 5.0;

    public CombatTestData(int _attack, int _defense, double _expected) {
        this.defense = _defense;
        this.attack = _attack;
        this.expected = _expected;
        this.calcTestRun();
    }

    public static void runTest(int _attack, int _defense, double _expected) {
        CombatTestData ctest = new CombatTestData(_attack, _defense, _expected);
        System.out.println(ctest._toString());
    }

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
    
    private String getResult() {
        if (Math.abs(this.actual - this.expected) < CombatTestData.TOLERANCE) {
            return "PASS";
        }
        return "FAIL";            
    }
    
    public String _toString() {
        return this.getResult() + " [A: " + this.attack + "  D: " + this.defense 
                + " Expected: " + this.expected + " Actual: " + this.actual + "]";
    }
    
    public void calcTestRun() {
        int totalHits = 0;
        for (int i = 1; i <= 1000; i++) {
            int hits = Combat.resolveHits(this.attack, this.defense);
            if (hits != 0) {
                totalHits++;
            }
        }
        this.actual = (double)totalHits / 1000 * 100;
    }
}
