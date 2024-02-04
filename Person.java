// KFK-WriteOb/Person.java
 
public class Person implements java.io.Serializable {
    private String name;
    private int    yearOfBirth;

    Person(String n, int y) {
        name        = n;
        yearOfBirth = y;
    }

    @Override
    public String toString() {
        return name + " (" + yearOfBirth + ")";
    }
}
