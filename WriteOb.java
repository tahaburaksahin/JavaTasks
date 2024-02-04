// KFK-WriteOb/WriteOb.java
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriteOb {

    public static void main(String[] args) {
        new WriteOb();
    }

    WriteOb() {
        Person[] persons =  {
                                new Person("Jane",1988),
                                new Person("Kate",1990),
                                new Person("Ella",1989),
                                new Person("Jill",1983)
                            };

        info("Before writing",persons);

          // writing
        try {
            ObjectOutputStream oos =
                new ObjectOutputStream(
                    new FileOutputStream("Data.dat"));
            oos.writeObject(persons);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

          // reading
        try {
            ObjectInputStream ois =
                new ObjectInputStream(
                    new FileInputStream("Data.dat"));
            persons = (Person[])ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        info("After  reading",persons);
    }

    private void info(String mes, Person[] persons) {
        System.out.print(mes + ":");
        for (Person p : persons)
            System.out.print(" " + p);
        System.out.println();
    }
}
