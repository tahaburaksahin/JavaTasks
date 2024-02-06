// KEP-WriteBin/WriteBin.java
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WriteBin {
    public static void main (String[] args) {
        long before = -284803830071168L;
        System.out.println("before = " + before);
        try (
            OutputStream os =
                    new FileOutputStream("WriteBin.bin");
        ) {
            for (int i = 7; i >= 0; --i)
                os.write( (int)(before >> i*8) );
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        long after = 0;
        try (
            InputStream is =
                    new FileInputStream("WriteBin.bin");
        ) {
            for (int i = 0; i < 8; ++i)
                after = (after << 8) | is.read();
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("after  = " + after);
    }
}
