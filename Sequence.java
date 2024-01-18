// AFD-WhileSeq/Sequence.java
// taha burak sahin pjatk

import java.util.Scanner;
import java.util.InputMismatchException;

public class Sequence {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.print("Enter an integer larger " +
                    "than 1 or 0 to finish: ");

            int k = 0;
            try {
                k = scan.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("Not an integer!");
                scan.skip(".*");
                continue;
            }

            if ( k == 0 ) System.exit(0);

            if ( k <= 1 ) {
                System.out.println("Number too small");
                continue;
            }

            System.out.println("Starting from: " + k);
            int cnt = 0;
            while ( k > 1 ) {
                if (k%2 == 0) k /= 2;
                else          k  = 3*k+1;
                cnt++;
                System.out.printf("a[%3d]=%3d%n",cnt,k);
            }
        }
    }
}
