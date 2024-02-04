// KFE-GrepNew/GrepNew.java
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.charset.StandardCharsets.UTF_8;

public class GrepNew {
    public static void main(String[] args) {
        String iFileName = "alice.txt";
        String oFileName = "grep_alice.txt";
        String wordSearchedFor = "Cheshire";

        Path filein = Paths.get(iFileName);
        if (!Files.exists(filein)     ||
            !Files.isReadable(filein) ||
             Files.isDirectory(filein)) {
            System.out.println("Invalid input file!!!");
            return;
        }

        try (
              // UTF8 is the default in nio classes,
              // but not in older io classes
            BufferedReader br =
                Files.newBufferedReader(filein, UTF_8);
            BufferedWriter bw =
                Files.newBufferedWriter(
                    Paths.get(oFileName), UTF_8))
        {
            String line;
            int lineNo = 0;
            while ( (line = br.readLine()) != null) {
                ++lineNo;
                if (line.indexOf(wordSearchedFor) >=0)
                    bw.write(String.format("Line %3d: %s%n",
                                           lineNo,line));
            }
            System.out.println("Results written to " +
                                oFileName);
        } catch(IOException e) {
            System.out.println("Something wrong");
            System.exit(1);
        }
    }
}
