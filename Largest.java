// ACB-CondOp/Largest.java
// Taha Burak Sahin PJATK

import java.util.Scanner;
import java.util.Locale;

public class Largest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        System.out.print(
                "Enter three numbers (with " +
                        "DOT as dec. separator!) -> ");

        var a = scan.nextDouble();
        var b = scan.nextDouble();
        var c = scan.nextDouble();

        var largest  = b >       a ? b :       a;
        largest      = c > largest ? c : largest;

        var smallest = b <       a  ? b :       a;
        smallest     = c < smallest ? c : smallest;

        System.out.println("Number " + largest + " is " +
                "the largest and " + smallest +
                " is the smallest");
    }
}
