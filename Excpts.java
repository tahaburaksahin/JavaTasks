// AYC-Excpts/Excpts.java
 // taha burak sahin pjatk
import javax.swing.JOptionPane;

public class Excpts {
    public static void main(String[] args) {
        boolean noGood = true;
        int     number = 0;

        while (noGood) {
            String s = JOptionPane.showInputDialog(
                null,"Enter two integers","Entering data",
                JOptionPane.QUESTION_MESSAGE);

            if (s == null) break;
            s = s.trim();
            if (s.length() == 0) continue;

            int spac = s.indexOf(' ');
            if (spac < 0) {
                JOptionPane.showMessageDialog(
                    null,"<html>Wrong data!" +
                         "<br />Try again!!!",
                    "ERROR",JOptionPane.ERROR_MESSAGE);
                continue;
            }

            try {
                int n1 = Integer.parseInt(
                                    s.substring(0,spac));
                int n2 = Integer.parseInt(
                             s.substring(spac+1).trim());
                number = n1/n2;
                noGood = false;

            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(
                    null,"<html>This were not integers!" +
                         "<br />Try again!!!",
                    "ERROR",JOptionPane.ERROR_MESSAGE);
                System.err.println("EXCEPTION " +
                    e.getMessage() + '\n' + "STACK TRACE:");
                e.printStackTrace();

            } catch(ArithmeticException e) {
                JOptionPane.showMessageDialog(
                    null,"<html>Division by zero!" +
                         "<br />Try again!!!",
                    "ERROR",JOptionPane.ERROR_MESSAGE);
                System.err.println("EXCEPTION " +
                    e.getMessage() + '\n' + "STACK TRACE:");
                e.printStackTrace();
            }
        }

        System.out.println(
            noGood ?
                "Program cancelled"
              : "Result of division: " + number);
    }
}
