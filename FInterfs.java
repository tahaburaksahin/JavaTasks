// EMC-FInterfs/FInterfs.java
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
public class FInterfs {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList(
            "Jane", "Sue", "Alice", "Kim", "Cecilia");
        List<Character> lc = mapFilter(
            ls, s -> s.length() > 3, s -> s.charAt(0));
        System.out.println(lc);
    }
    static <T,R> List<R> mapFilter(
            List<T> list, Predicate<T> p, Function<T,R> f) {
        List<R> n = new ArrayList<>();
        for (T e : list) if(p.test(e)) n.add(f.apply(e));
        return n;
    }
}
