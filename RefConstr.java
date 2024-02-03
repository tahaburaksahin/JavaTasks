// LDH-RefConstr/RefConstr.java
 
import java.util.Arrays;
import java.util.stream.Stream;

public class RefConstr {
    public static void main (String[] args) {
        String[] names = {"Ada", "Bea", "Sue", "Lea" };
        Person[] persons =
            Stream.of(names)
             .map(Person::new)
             .toArray(Person[]::new); // otherwise Object[]
        System.out.println(Arrays.toString(persons));
    }
}

class Person {
    private String name;
    Person(String n)        { name = n; }
    public String getName() { return name; }
    @Override
    public String toString(){ return "Miss " + name; }
}
