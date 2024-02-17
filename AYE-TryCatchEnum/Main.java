// AYE-TryCatchEnum/Main.java
 
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {

        EType typ;
        do {
            String ans = JOptionPane.showInputDialog(null,
                              "Enter anything","Question",
                            JOptionPane.QUESTION_MESSAGE);

            WhatIsIt what = new WhatIsIt(ans);

            typ = what.getType();

            String   msg = "Type: " + typ + ", v = ";

            switch (typ) {
                case I: msg = msg + what.getInt();
                    break;
                case R: msg = msg + what.getDouble();
                    break;
                case S: msg = msg + what.getString();
                    break;
                case E: msg = msg + "\"\"";
                    break;
                case N: msg = msg + "end of program";
                    break;
            }
            JOptionPane.showMessageDialog(null,msg,"Result",
                           JOptionPane.INFORMATION_MESSAGE);

        } while(typ != EType.N);

        System.exit(0);
    }
}
