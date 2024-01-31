// HUT-RPNTokenizer/RPNTokenizer.java
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import static java.io.StreamTokenizer.TT_EOF;
import static java.io.StreamTokenizer.TT_NUMBER;
import static java.io.StreamTokenizer.TT_WORD;

public class RPNTokenizer {
    public static void main(String[] args) {
        Deque<Double>  stack = new ArrayDeque<Double>();
        Reader            rd = null;
        StreamTokenizer sTok = null;
        String filename      = "RPNTokenizer.dat";
        double result        = 0;

        try {
            rd   = new BufferedReader(
                       new FileReader("RPN.dat"));
            sTok = new StreamTokenizer(rd);
            sTok.eolIsSignificant(false);
            sTok.slashSlashComments(true);
            sTok.slashStarComments(true);

            while (sTok.nextToken() != TT_EOF) {
                switch (sTok.ttype) {
                    case TT_NUMBER:
                        stack.push(sTok.nval);
                        break;
                    case TT_WORD:
                        char c = sTok.sval.charAt(0);
                        double  a2 = stack.pop();
                        double  a1 = stack.pop();
                        double res = 0;
                        switch (c) {
                            case 'm': // multiplication
                                res = a1*a2; break;
                            case 'a': // addition
                                res = a1+a2; break;
                            case 's': // subtraction
                                res = a1-a2; break;
                            case 'd': // division
                                res = a1/a2; break;
                            default:
                                System.err.println(
                                        "Wrong operation");
                                System.exit(1);
                        }
                        stack.push(res);
                        break;
                }
            }

            result = stack.pop();

            if (!stack.isEmpty()) {
                System.err.println("Non-empty stack");
                System.exit(1);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Problems with " + filename);
            e.printStackTrace();
            System.exit(1);
        } catch(IOException e) {
              System.err.println("IO Error");
              System.exit(1);
        } finally {
            try { if (rd != null) rd.close(); }
            catch(IOException ignore) {       }
        }

        System.out.println("Result is " + result);
    }
}
