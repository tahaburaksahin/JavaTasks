// taha burak sahin pjatk
import java.util.Scanner;

public class Prime1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print(
                    "Enter natural number (0 to exit) -> ");
            int n = scan.nextInt();

            if (n == 0) break;

            boolean prime = true;

            if (n == 1) {
                System.out.println("Number 1 is neither " +
                        "prime nor composite");
                continue;
            } else if (n > 2 && n%2 == 0) {
                prime = false;
            } else {
                int p = 3;
                while (p*p <= n) {
                    if (n%p == 0) {
                        prime = false;
                        break;
                    }
                    p += 2;
                }
            }
            System.out.println("Number " + n + " is " +
                    (prime ? "prime" : "composite"));
        }
        scan.close();
    }
}
