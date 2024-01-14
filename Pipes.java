// KFN-Pipes/Pipes.java
// Taha Burak Sahin PJATK

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Pipes {
    public static void main(String[] args) {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream  pis = new PipedInputStream();
        try {
            pis.connect(pos); // or pos.connect(pis);
        } catch(IOException exc) {
            System.err.println("Should never happen");
            System.exit(1);
        }
        new WritingThread(pos).start();
        new ReadingThread(pis).start();
    }
}

class WritingThread extends Thread {
    OutputStream os;

    public WritingThread(OutputStream os) {
        this.os = os;
    }

    @Override
    public void run() {
        int totalSize = 8*1024;
        byte[] array = new byte[totalSize];
        int size = 107;
        // writing bigger and bigger chunks...
        try {
            while (size <= totalSize) {
                System.out.println("WRITING "+size+" bytes");
                os.write(array,0,size);
                size *= 2;
            }
            os.close(); // <-- obligatory before thread dies!
        } catch (IOException exc) {
            System.err.println("Error when writing");
            System.exit(1);
        }
    }
}

class ReadingThread extends Thread {
    InputStream is;

    public ReadingThread(InputStream is) {
        this.is = is;
    }

    @Override
    public void run() {
        int totalSize = 8*1024, size;
        byte[] array = new byte[totalSize];
        try {
            while ((size=is.read(array,0,totalSize)) > 0) {
                System.out.println("Reading "+size+" bytes");
            }
            is.close();
        } catch (IOException exc) {
            System.err.println("Error when reading");
            System.exit(1);
        }
    }
}
