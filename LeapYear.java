// ABX-Ifs/LeapYear.java
// taha burak sahin pjatk
import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a year (integer) -> ");
        int year = scan.nextInt();
        scan.close();

        boolean is_leap;

        if (year%400 == 0)
            is_leap = true;
        else if (year%100 == 0)
            is_leap = false;
        else if (year%4 == 0)
            is_leap = true;
        else
            is_leap = false;
        // ?: operator used below!
        System.out.println("Year " + year + " is "        +
                (is_leap? "" : "not ") + "a leap year");
    }
}
