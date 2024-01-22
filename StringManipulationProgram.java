import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringManipulationProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // String manipulation operations
        System.out.println("Length of the string: " + inputString.length());
        System.out.println("Lowercase: " + inputString.toLowerCase());
        System.out.println("Uppercase: " + inputString.toUpperCase());
        System.out.println("First character: " + inputString.charAt(0));
        System.out.println("Last character: " + inputString.charAt(inputString.length() - 1));
        System.out.println("Contains \"Java\": " + inputString.toLowerCase().contains("java"));
        System.out.println("Modified string: " + inputString.replace('a', 'X'));

        // Regular expressions
        System.out.println("Is alphanumeric: " + inputString.matches("^[a-zA-Z0-9]*$"));

        // Word extraction using regular expression
        Pattern wordPattern = Pattern.compile("\\b\\w+\\b");
        Matcher wordMatcher = wordPattern.matcher(inputString);
        System.out.print("Words: [");
        while (wordMatcher.find()) {
            System.out.print(wordMatcher.group() + ", ");
        }
        System.out.println("]");

        // Email address extraction using regular expression
        Pattern emailPattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b");
        Matcher emailMatcher = emailPattern.matcher(inputString);
        System.out.print("Email addresses: [");
        while (emailMatcher.find()) {
            System.out.print(emailMatcher.group() + ", ");
        }
        System.out.println("]");

        scanner.close();
    }
}