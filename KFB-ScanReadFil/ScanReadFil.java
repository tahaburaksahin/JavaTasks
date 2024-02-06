// KFB-ScanReadFil/ScanReadFil.java
 
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ScanReadFil {
    public static void main (String[] args) {

        Scanner scan = null;
        try {
            scan = new Scanner(Paths.get("alice.txt"),
                               "UTF-8");
        } catch(IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return;
        }

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            System.out.println(line);
        }
        scan.close();
    }
}
