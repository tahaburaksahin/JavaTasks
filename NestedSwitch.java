// ACK-NestedSwitch/NestedSwitch.java
// taha burak sahin pjatk

import java.util.Scanner;

public class NestedSwitch {

    enum E_Day      { WEEK,  SATURDAY,   SUNDAY };
    enum E_Position { STAFF, SUPERVISOR, CE };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter type of day (1-3) -> ");
        int day = scan.nextInt();
        E_Day e_day;
        switch (day) {
            // default can be anywhere
            default: throw new IllegalArgumentException(
                    "Illegal day");
            case  1: e_day = E_Day.WEEK;     break;
            case  2: e_day = E_Day.SATURDAY; break;
            case  3: e_day = E_Day.SUNDAY;   break;
        }

        System.out.print("Enter position    (1-3) -> ");
        int pos = scan.nextInt();
        scan.close();
        E_Position e_pos;
        switch (pos) {
            default: throw new IllegalArgumentException(
                    "Illegal position");
            case  1: e_pos = E_Position.STAFF;      break;
            case  2: e_pos = E_Position.SUPERVISOR; break;
            case  3: e_pos = E_Position.CE;         break;
        }

        double salary = 400;

        switch (e_pos) {
            case STAFF:
                switch (e_day) {
                    case WEEK:                    break;
                    case SATURDAY: salary *= 1.1; break;
                    case SUNDAY:   salary *= 1.3; break;
                }
                break; // <- do not forget!
            case SUPERVISOR:
                salary *= 2;
                switch (e_day) {
                    case WEEK:                    break;
                    case SATURDAY: salary *= 1.4; break;
                    case SUNDAY:   salary *= 1.6; break;
                }
                break;
            case CE:
                salary *= 20;
                switch (e_day) {
                    case WEEK:                    break;
                    case SATURDAY: salary *= 4.0; break;
                    case SUNDAY:   salary *= 9.0; break;
                }
                break;
        }

        System.out.println("Salary for employee of type " +
                e_pos + " on day of type " + e_day + " is $"  +
                salary);
    }
}
