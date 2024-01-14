// LAA-MemChannels/MemChannels.java
// Taha Burak Sahin PJATK

import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public class MemChannels {
    static final int DSIZE = 4;

    public static void main(String[] args)
            throws Exception {

        FileChannel fc;

        // output file channel (where doubles will go)
        fc = new FileOutputStream("data.dat").getChannel();

        // creating a byte buffer
        ByteBuffer bb = ByteBuffer.allocateDirect(8*DSIZE);

        // put DSIZE doubles into the buffer
        for (int i = 0; i < DSIZE; ++i)
            bb.putDouble(1 + 0.25*i);
        // prepare buffer for writting
        bb.flip();
        // write to channel from buffer
        fc.write(bb);
        // clear the buffer
        bb.clear();

        // and again; DSIZE doubles more
        for (int i = 0; i < DSIZE; ++i)
            bb.putDouble(3 + 0.25*i);
        bb.flip();
        fc.write(bb);
        bb.clear();

        // done, 2*DSIZE doubles written to file
        fc.close();


        // input file channel
        fc = new RandomAccessFile("data.dat","rw").
                getChannel();

        // how many bytes are there? (should be 2*8*DSIZE)
        int byteSize = (int)(fc.size());

        // buffer with data from the file (modifications
        // would  n o t  be reflected in the file if
        // mode were MapMode.PRIVATE)
        MappedByteBuffer mbb = fc.map(
                FileChannel.MapMode.READ_WRITE,0,byteSize);
        // file is closed but we have it in the buffer...
        fc.close();
        // is the data correct?
        for (int i = 0; i < byteSize/8; ++i)
            System.out.printf("%.2f ",mbb.getDouble());
        System.out.println();
        mbb.flip();

        // modifying data in the buffer
        double first = mbb.getDouble(0);
        double last  = mbb.getDouble(byteSize-8);
        mbb.putDouble(0,         last);
        mbb.putDouble(byteSize-8,first);
        // to be sure that changes made go to the file
        mbb.force();

        // reading the file again and checking
        // if the modifications have been saved
        fc = new RandomAccessFile("data.dat","rw").
                getChannel();
        bb = ByteBuffer.allocateDirect(2*8*DSIZE);
        fc.read(bb);
        fc.close();
        bb.flip();
        for (int i = 0; i < 2*DSIZE; ++i)
            System.out.printf("%.2f ",bb.getDouble());
        System.out.println();

        new File("data.dat").delete();
    }
}
