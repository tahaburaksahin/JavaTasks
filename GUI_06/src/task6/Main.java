package task6;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String[] arr = {    "office A", "John", "Doe",
                "office B", "John", "Brown",
                "office C", "Mary", "Jones",
                "office B", "Adam", "Rust",
                "office C", "Cindy", "Frost",
                "office A", "Kate", "Coe",
                "office A", "Bill", "Brown"
        };

        Map<String, List<Person>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i+=3) {
            map.putIfAbsent(arr[i], new LinkedList<>());
            map.get(arr[i]).add(new Person(arr[i+1], arr[i+2]));
        }

        System.out.println(map);

        Map.Entry<String, List<Person>> max = null;
        for (Map.Entry<String, List<Person>> entry : map.entrySet()) {
            if (max == null)
                max = entry;
            else if (max.getValue().size() < entry.getValue().size())
                max = entry;
        }

        System.out.println(max.getKey() + ": " + max.getValue().size() + " users");
    }
}
