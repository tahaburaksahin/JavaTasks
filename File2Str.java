// KFI-File2Str/File2Str.java
 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.charset.StandardCharsets.UTF_8;

public class File2Str {
    public static void main(String[] args) {
        String text = null;

        try {
            byte[] bytes =
                Files.readAllBytes(Paths.get("pangram.txt"));
            text = new String(bytes, UTF_8);
        } catch(IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("***** File read (1):\n" + text);

          // simpler way, since java 11
        try {
            text = Files.readString(
                            Paths.get("pangram.txt"), UTF_8);
        } catch(IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("***** File read (2):\n" + text);
    }
}
