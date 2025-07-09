package configs;

public class InterestConfiguration {
    private static final double savingRate = 0.03;
    private static final double checkingRate = 0.04;


    public static double getSavingRate() {
        return savingRate;
    }

    public static double getCheckingRate() {
        return checkingRate;
    }
}
