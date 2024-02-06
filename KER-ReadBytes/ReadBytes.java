// KER-ReadBytes/ReadBytes.java
 
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadBytes {

    public static void main(String[] args) {
        new ReadBytes();
    }

    ReadBytes() {
        File f =
            new File( // a really big file...
                "/home/werner/BOOKS/matematyka_BOOKS/" +
                "abramowitz_and_stegun-20121203T1547.tgz");

        int ilecntr=0, ileasci=0, ileextd=0, bajt, ile;
        long start=0,  time=0;

        try {
            InputStream fis = new FileInputStream(f);
            start = System.currentTimeMillis();
            while ( (bajt = fis.read()) != -1 ) {
                if      (bajt <  32) ++ilecntr;
                else if (bajt < 128) ++ileasci;
                else                 ++ileextd;
            }
            time = System.currentTimeMillis() - start;
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        info(f,ilecntr,ileasci,ileextd,time);

        ilecntr = ileasci = ileextd = 0;

        try {
            BufferedInputStream bis =
                new BufferedInputStream(
                    new FileInputStream(f));
            start = System.currentTimeMillis();
            while ( (bajt = bis.read()) != -1 ) {
                if      (bajt <  32) ilecntr++;
                else if (bajt < 128) ileasci++;
                else                 ileextd++;
            }
            time = System.currentTimeMillis() - start;
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        info(f,ilecntr,ileasci,ileextd,time);

        ilecntr = ileasci = ileextd = 0;

        try {
            BufferedInputStream bis =
                new BufferedInputStream(
                    new FileInputStream(f));
            byte[] bytes = new byte[8192];
            start = System.currentTimeMillis();
            while ( (ile = bis.read(bytes)) > 0 ) {
                for (int i = 0; i < ile; ++i) {
                    if      (bytes[i] <  0) ileextd++;
                    else if (bytes[i] < 32) ilecntr++;
                    else                    ileasci++;
                }
            }
            time = System.currentTimeMillis() - start;
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        info(f,ilecntr,ileasci,ileextd,time);

        ilecntr = ileasci = ileextd = 0;

        Path path = f.toPath();
        try {
            start = System.currentTimeMillis();
            byte[] bytes = Files.readAllBytes(path);
            for (byte b : bytes) {
                if      (b <   0) ++ileextd;
                else if (b <  32) ++ilecntr;
                else              ++ileasci;
            }
            time = System.currentTimeMillis() - start;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        info(f,ilecntr,ileasci,ileextd,time);
    }

    void info(File f, int ilecntr, int  ileasci,
                      int ileextd, long time) {
        System.out.println(
            "\nFile " + f.getAbsolutePath() + "\nis " +
            f.length() + " bytes long. It contains:\n  " +
            ilecntr + " control characters\n  " +
            ileasci + " ASCII non-control\n  " +
            ileextd + " \"extended\" ASCII." +
            "\nTime: " + (double)time/1000 + " seconds\n");
    }
}
