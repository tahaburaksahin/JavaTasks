import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        // Password validation
        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid. Please ensure it meets the criteria.");
        }

        scanner.close();
    }

    // Password validation method
    public static boolean isValidPassword(String password) {
        // Check length
        if (password.length() < 8) {
            return false;
        }

        // Check for at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check for at least one digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check for at least one special character
        if (!password.matches(".*[!@#$%^&].*")) {
            return false;
        }

        // If all criteria are met, the password is valid
        return true;
    }
}