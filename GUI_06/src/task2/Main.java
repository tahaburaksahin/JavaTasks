package task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Garment[] u = new Garment[]{new Garment(59.99, Size.XL, "Red", "Sweater", "Wool"),
                new Garment(20.30, Size.M, "Yellow", "Pants", "Corduroy"),
                new Garment(99.00, Size.XS, "Pink", "T-shirt", "Cotton")};

        Arrays.sort(u);
        for (Garment i : u) {
            System.out.println(i);
        }

        System.out.println();

        Arrays.sort(u, (x, y) -> {
            return Double.compare(x.getPrice(), y.getPrice());
        });

        for (Garment i : u) {
            System.out.println(i);
        }
    }
}
