// HUM-HashEquals/Person.java
 
public class Person {

    private String name;
    private String idNumber;

    public Person(String name, String idNumber) {
        this.name     = name;
        this.idNumber = idNumber;
    }

    /*
    @Override
    public boolean equals(Object other) {
        if (other == null ||
            getClass() != other.getClass()) return false;
        Person p = (Person)other;
        return idNumber.equals(p.idNumber) &&
                   name.equals(p.name);
    }
    /**/

    /*
    @Override
    public int hashCode() {
        return 17*name.hashCode() + idNumber.hashCode();
    }
    /**/

    @Override
    public String toString() {
        return name + "(" + idNumber + ")";
    }
}
