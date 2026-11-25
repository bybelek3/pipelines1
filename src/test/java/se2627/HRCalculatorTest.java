package se2627;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HRCalculatorTest {

    @Test
    public void testValidMaxHR() {
        assertEquals(195, HRCalculator.calculateMaxHR(25));
    }

    @Test
    public void testInvalidMaxHR_ageTooHigh() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(500));
    }

    @Test
    public void testInvalidMaxHR_ageTooLow() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(-1));
    }

    @Test
    public void testResting() {
        assertEquals("Resting", HRCalculator.getWorkoutZone(20, 99));
    }

    @Test
    public void testRecovery() {
        assertEquals("Recovery", HRCalculator.getWorkoutZone(20, 100));
        assertEquals("Recovery", HRCalculator.getWorkoutZone(20, 119));
    }

    @Test
    public void testFatBurn() {
        assertEquals("Fat Burn", HRCalculator.getWorkoutZone(20, 120));
        assertEquals("Fat Burn", HRCalculator.getWorkoutZone(20, 139));
    }

    @Test
    public void testAerobic() {
        assertEquals("Aerobic", HRCalculator.getWorkoutZone(20, 140));
        assertEquals("Aerobic", HRCalculator.getWorkoutZone(20, 159));
    }

    @Test
    public void testAnaerobic() {
        assertEquals("Anaerobic", HRCalculator.getWorkoutZone(20, 160));
        assertEquals("Anaerobic", HRCalculator.getWorkoutZone(20, 179));
    }

    @Test
    public void testVO2Max() {
        assertEquals("VO2 Max", HRCalculator.getWorkoutZone(20, 180));
        assertEquals("VO2 Max", HRCalculator.getWorkoutZone(20, 195));
    }

    @Test
    public void testInvalidWorkoutAge() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(-1, 100));
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(121, 100));
    }

    @Test
    public void testInvalidBPM() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(20, 0));
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(20, -10));
    }

    @Test
    public void testAgeBoundaries() {
        assertEquals(220, HRCalculator.calculateMaxHR(0));
        assertEquals(100, HRCalculator.calculateMaxHR(120));
    }
}