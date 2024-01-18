// AFB-WhileBis/Prime.java
// taha burak sahin pjatk

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        MAIN_LOOP:
        while (true) {
            System.out.print(
                    "Enter natural number (0 to exit) -> ");
            int n = scan.nextInt();

            if (n == 0) break;

            if (n == 1) {
                System.out.println("Number 1 is neither " +
                        "prime nor composite");
                continue;

            } else if (n > 2 && n%2 == 0) {
                System.out.println("Number " + n +
                        ", being even, is composite");
                continue;

            } else {
                int p = 3;
                while (p*p <= n) {
                    if (n%p == 0) {
                        System.out.println("Number " + n +
                                " is composite");
                        continue MAIN_LOOP;
                    }
                    p += 2;
                }
                System.out.println("Number " + n +
                        " is prime");
            }
        }
        scan.close();
    }
}
