// HUM-HashEquals/AHash.java
 
import java.util.HashMap;
import java.util.Map;

public class AHash {
    public static void main(String[] args) {
        Map<Person,String> map = new HashMap<>();

        map.put(new Person("Sue","123456"),"Sue");

          // new object, but should be equivalent to
          // the one which has been put into the map
        Person sue = new Person("Sue","123456");

        if (map.containsKey(sue))
            System.out.println(sue + " has been found");
        else
            System.out.println(sue + " has NOT been found");
    }
}
