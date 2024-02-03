// LDE-Grouping/Grouping.java
 
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Grouping {
    public static void main (String[] args) {
        List<Person> list = Arrays.asList(
                new Person("John",  "UK"),
                new Person("Mary",  "US"),
                new Person("Xue",   "CH"),
                new Person("Kate",  "UK"),
                new Person("Janek", "PL"),
                new Person("Cindy", "US"),
                new Person("Bao",   "CH"),
                new Person("Kasia", "PL")
        );

          // collect gives Map<String,List<Person>>
          // groupingBy expects Function...
        list
         .stream()
         .collect(Collectors.groupingBy(Person::getCountry))
         .entrySet()
         .stream()
         .forEach(e -> System.out.println(e.getKey() +
                                 " -> " + e.getValue()));
    }
}

class Person {
    private final String name;
    private final String country;
    public Person(String n, String c) {
        name = n; country = c;
    }
    public String getName()    { return name;    }
    public String getCountry() { return country; }
    @Override
    public String toString() {
        return name + " (" + country + ")";
    }
}
