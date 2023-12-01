// Taha Burak Sahin PJATK


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class task4 {
    public static void main(String[] args) {
        final int N = 90;
        final int NUM_OF_SIMULATIONS = 100000;
        int totalBoxes = 0;

        for (int i = 0; i < NUM_OF_SIMULATIONS; ++i) {
            totalBoxes += boxesBought(N);
        }

        double aver = totalBoxes / (double) NUM_OF_SIMULATIONS;
        System.out.println("***** N = " + N);
        System.out.println("Average : " + aver);
        System.out.println("Expected: " + N * harmo(N));
    }

    static int boxesBought(int coupons) {
        Set<Integer> collectedCoupons = new HashSet<>();
        Random rand = new Random();
        int boxesCount = 0;

        while (collectedCoupons.size() < coupons) {
            int newCoupon = rand.nextInt(coupons) + 1;
            collectedCoupons.add(newCoupon);
            boxesCount++;
        }

        return boxesCount;
    }

    static double harmo(int n) {
        double harmonicSum = 0.0;

        for (int i = 1; i <= n; i++) {
            harmonicSum += 1.0 / i;
        }

        return harmonicSum;
    }
}
