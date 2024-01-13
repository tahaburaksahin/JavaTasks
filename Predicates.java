// LDB-Predicates/Predicates.java

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Predicates {
    public static void main (String[] args) {
        Predicate<Integer> p1 = e -> e%2 ==  0;
        Predicate<Integer> p = p1
                .and(e -> e <= 10)
                .or(e -> e == 19);
        List<Integer> filteredList =
                Stream.of(1,2,3,4,19,22,12)
                        .filter(p)
                        .collect(Collectors.toList());
        filteredList.stream().forEach(System.out::println);
        // prints 2, 4, 19
    }
}
