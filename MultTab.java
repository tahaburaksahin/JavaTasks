// AFP-MultTab/MultTab.java
//taha burak sahin pjatk 

import static java.lang.System.out;
import java.util.Scanner;

//   Printing multiplication table

public class MultTab {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            out.print(
                "\nEnter maximum factor (0 to exit) -> ");
            int n = scan.nextInt();

            if (n == 0) break;

            for (int p = 1; p <= n; ++p) {
                for (int q = 1; q <= n; ++q)
                    out.printf("%4d",p*q);
                out.println();
            }
        }
    }
}
