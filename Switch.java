// ACD-Switch/Switch.java
// Taha Burak Sahin PJATK

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print(
                "Enter a single hex digit -> ");
        char ch = scan.next().charAt(0);
        scan.close();

        // toLower by hand...
        if (ch >= 'A' && ch <= 'Z')
            ch = (char)(ch + 'a' - 'A');

        int num;

        switch (ch) {
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
                num = 10 + ch - 'a';
                break;
            case '0': case '1': case '2': case '3': case '4':
            case '5': case '6': case '7': case '8': case '9':
                num = ch - '0';
                break;
            default:
                num = -1;
        }

        System.out.println("Character '" + ch + "' is " +
                (num >= 0 ? "" : "not ") + "a hex digit. "    +
                "Its numerical value: " + num);
    }
}
