// KFG-RWTxtNew/ARM.java
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.System.out; // <--just for fun
import static java.nio.charset.StandardCharsets.UTF_8;

public class ARM {
    public static void main(String[] args) {
        try (BufferedReader br =
                Files.newBufferedReader(
                    Paths.get("ARM.java"),UTF_8);
             BufferedWriter bw =
                 Files.newBufferedWriter(
                    Paths.get("ARM.java.BAK"),UTF_8)
            )
        {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            out.println("Done");    // <-- no System...
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
