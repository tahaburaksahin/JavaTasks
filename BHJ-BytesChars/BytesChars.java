// BHJ-BytesChars/BytesChars.java
 
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;
import static java.nio.charset.StandardCharsets.UTF_8;

public class BytesChars {
    public static void main(String[] args) {
        System.out.print(
                "Type something and press enter ==> ");
        InputStream is = System.in;
        try {
            char c = ' ';
            while (true) {
                int i = is.read();
                c = (char)i;
                if (c == '\r' || c == '\n') break;
                System.out.printf("%3d ('", i);
                System.out.println(c + "') =>" +
                    " digit:" + Character.isDigit(c) +
                    " letter:" + Character.isLetter(c) +
                    " white:" + Character.isWhitespace(c));
            }
        } catch(IOException e) {
            e.printStackTrace();
            return;
        }
          // we don't close 'is' here, as this is the
          // standard input and we will use it later
        System.out.print("Type something again ==> ");
        try (
            Reader rd =
                new InputStreamReader(System.in, UTF_8)
        ) {
            char c = ' ';
            while (true) {
                int i = rd.read();
                c = (char)i;
                if (c == '\r' || c == '\n') break;
                System.out.printf("%#5x ('", i);
                System.out.println(c + "') =>" +
                    " digit:" + Character.isDigit(c) +
                    " letter:" + Character.isLetter(c) +
                    " white:" + Character.isWhitespace(c));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
