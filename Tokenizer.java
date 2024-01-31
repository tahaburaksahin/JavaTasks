// HUS-Tokens/Tokenizer.java
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.StreamTokenizer;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.io.StreamTokenizer.TT_EOF;
import static java.io.StreamTokenizer.TT_NUMBER;
import static java.io.StreamTokenizer.TT_WORD;

public class Tokenizer {
    public static void main(String[] args) {
        double result = 0;
        StringBuilder sb = null;
        try ( // UTF8 assumed
            BufferedReader br =
                Files.newBufferedReader(
                    Paths.get("Tokenizer.dat")))
        {
            StreamTokenizer sTok = new StreamTokenizer(br);
            sTok.eolIsSignificant(false);
            sTok.slashSlashComments(true);
            sTok.slashStarComments(true);
            sb = new StringBuilder();
            while (sTok.nextToken() != TT_EOF) {
                switch (sTok.ttype) {
                case TT_NUMBER:
                    result += sTok.nval;
                    break;
                case TT_WORD:
                    sb.append(" " + sTok.sval);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found");
            return;
        } catch(IOException e) {
            System.err.println("IO Error");
            return;
        }
        System.out.println("Total population: " + result);
        System.out.println("Cities: " +
                    sb.toString().substring(1));
    }
}
