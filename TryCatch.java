// AXX-TryCatch/TryCatch.java
// taha burak sahin pjatk
import javax.swing.JOptionPane;

public class TryCatch {
    public static void main(String[] args) {
        boolean noGood = true;
        int     number = 0;

        while (noGood) {
            String s = JOptionPane.showInputDialog(
                null,"Enter an integer","Entering data",
                JOptionPane.QUESTION_MESSAGE);

            if (s == null)       break;
            if (s.length() == 0) continue;
            try {
                number = Integer.parseInt(s);
                noGood = false;
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(
                    null,"<html>This is not an integer!" +
                         "<br />Try again!!!",
                    "ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }

        System.out.println(
            noGood ?
                "Program cancelled" : "Entered: " + number);
    }
}
