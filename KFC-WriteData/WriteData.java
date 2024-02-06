// KFC-WriteData/WriteData.java
 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class WriteData {
    public static void main(String[] args) {
        String   str = "Array";
        double[] tab = new double[] {1.5, 2.5, 4.5};

        info("Before writing:",str,tab);
          // writing
        try {
            DataOutputStream dos = new DataOutputStream(
                    new FileOutputStream("Data.dat"));

            dos.writeUTF(str);
            dos.writeInt(tab.length);
            for (int i = 0; i < tab.length; i++)
                dos.writeDouble(tab[i]);
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
          // reading
        try {
            DataInputStream dis = new DataInputStream(
                new FileInputStream("Data.dat"));

            str = dis.readUTF();
            tab = new double[dis.readInt()];
            for (int i = 0; i < tab.length; i++)
                tab[i] = dis.readDouble();
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        info("After reading it back:",str,tab);
    }

    private static void info(String mes, String str,
                             double[] tab) {
        System.out.print("\n" + mes + "\nstr = " +
                                str + "\ntab = ");
        for (double d : tab) System.out.print(" " + d);
        System.out.println();
    }
}
