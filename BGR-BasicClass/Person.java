// BGR-BasicClass/Person.java
 
public class Person {

    private String name;
    private int birth_year;

    public Person(String name, int r) {
        this.name = name;
        birth_year = r;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return birth_year;
    }
    /**/
    @Override
    public String toString() {
        return name + " (b. " + birth_year + ")";
    }
    /**/

    public boolean isOlderThan(Person other) {
        return birth_year < other.birth_year;
    }
}
