// KFD-Grep/Grep.java
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Grep {
    public static void main(String[] args) {
        File filein = new File("alice.txt");
        String wordSearchedFor = "Cheshire";

        if ( !filein.exists()     ||
             !filein.canRead()    ||
              filein.isDirectory()  ) {
            System.out.println("Invalid input file !!!");
            System.exit(1);
        }
        File fileou = new File("grep_" + filein.getName());
        BufferedReader br = null;
        BufferedWriter bw = null;
        String LF=System.getProperty("line.separator");

        try {
            br = new BufferedReader(
                     new FileReader(filein));
            bw = new BufferedWriter(
                     new FileWriter(fileou));
            String line;
            int lineNo = 0;
            while ( (line = br.readLine()) != null) {
                ++lineNo;
                if (line.indexOf(wordSearchedFor) >=0)
                    bw.write(String.format("Line %2d: %s%s",
                                           lineNo,line,LF));
            }

        } catch (IOException e) {
            System.out.println("Problems with reading");
        } finally {
            try { if (br != null) br.close(); }
            catch(IOException ignore) { }
            try { if (bw != null) bw.close(); }
            catch(IOException ignore) { }
            System.out.println("Results written to " +
                            fileou.getAbsolutePath());
        }
    }
}
