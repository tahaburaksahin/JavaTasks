// GXP-Split/Splitting.java
 
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Splitting {
    public static void main(String[] args) {
        try (
            BufferedReader br = Files.newBufferedReader(
                    Paths.get("Splitting.txt"), UTF_8)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] array = line.split(
                        "(\\b\\s+\\b|\\b\\s*\\p{P}\\s*\\b)");
                System.out.print("|");
                for (String s:array) System.out.print(s+"|");
                System.out.println();
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
}
