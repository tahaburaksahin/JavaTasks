// ACE-SwitchArrow/SwitchArrow.java
// Taha Burak Sahin PJATK

import java.util.Scanner;

public class SwitchArrow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print(
                "Enter a natural number -> ");
        int k = scan.nextInt();
        scan.close();

        String part1 = k + " is of the form ";
        String part2 = null;

        switch (k % 4) {
            case 0 -> part2 = "4n";
            case 1 -> part2 = "4n+1";
            case 2 -> part2 = "4n+2";
            case 3 -> part2 = "4n+3";
            default-> {
                part2 = " ... probably negative";
                System.out.println("You were expected to " +
                        "enter a *natural* number!");
            }
        }
        System.out.println(part1 + part2);
    }
}
