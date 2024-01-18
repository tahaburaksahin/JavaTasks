// AFG-DoWhile/DoWhile.java

import java.util.Scanner;
/*
    Finding and printing digits of natural number
*/
// taha burak sahin pjatk


public class DoWhile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print(
                    "\nEnter natural number (0 to exit) -> ");
            int n = scan.nextInt();

            if (n == 0) break;

            System.out.print("Digits of " + n + ": |");
            int numb = 1;
            while (numb <= n/10) numb *= 10;
            do {
                int dig = n/numb;
                n -= dig*numb;
                numb /= 10;
                System.out.print(" " + dig + " |");
            } while (numb > 0);
            System.out.println();
        }
    }
}
