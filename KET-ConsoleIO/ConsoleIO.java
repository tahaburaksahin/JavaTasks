// KET-ConsoleIO/ConsoleIO.java
 
import java.io.Console;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Calendar;

public class ConsoleIO {
    public static void main(String[] args) {

        Console cons = System.console();
        if (cons == null) {
            System.err.println(
                "No console attached to this JVM\nAre" +
                "you sure this is a console application?");
            System.exit(1);
        }

          // we can write to the console
          // using formatted strings
        cons.printf("%nHi, %s%nHow are you doing today"+
                        " (%2$tA, %2$te %2$tb %2tY)?%n",
                    System.getProperty("user.name"),
                    Calendar.getInstance());

          // we can read with formatted prompts
        String ans = cons.readLine("%s --> ","Your answer");

          // we can get PrintWriter and use 'println'
        PrintWriter pw = cons.writer();
        pw.println("I am glad that you are doing " + ans);

          // reading password returns an array of chars
        char[] pass = cons.readPassword(
                "[password for %s (will not be echoed)]: ",
                System.getProperty("user.name"));

          // avoid converting passwords to a Strings!!!
        cons.printf("Your top secret pass is %s%n",
                    new String(pass));
          // you should always manually erase character
          // arrays with passwords  as soon as possible
        Arrays.fill(pass,' ');
    }
}
