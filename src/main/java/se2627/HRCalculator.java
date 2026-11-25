package se2627;

public class HRCalculator {

    public static int calculateMaxHR(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age out of bounds");
        }
        return 220 - age;
    }

    public static String getWorkoutZone(int age, int bpm) {
        int maxHR = calculateMaxHR(age);

        if (bpm <= 0) {
            throw new IllegalArgumentException("Invalid BPM");
        }

        double percentage = (double) bpm / maxHR;

        if (percentage < 0.50) {
            return "Resting";
        } else if (percentage < 0.60) {
            return "Recovery";
        } else if (percentage < 0.70) {
            return "Fat Burn";
        } else if (percentage < 0.80) {
            return "Aerobic";
        } else if (percentage < 0.90) {
            return "Anaerobic";
        } else {
            return "VO2 Max";
        }
    }
}