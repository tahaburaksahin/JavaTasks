// LDF-StreamGrep/StreamGrep.java
 
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.nio.charset.StandardCharsets.UTF_8;

public class StreamGrep {
    public static void main(String[] args) {
        List<String> list = null;
        try (Stream<String> lines =
                Files.lines(Paths.get("StreamGrep.java"),
                            UTF_8)) {
            String substr = "String";
            list = lines
                     // Predicate expected
                  .filter(s -> s.indexOf(substr) >= 0)
                     // Consumer expected
                  .peek(System.out::println)
                  .collect(Collectors.toList());
        } catch(IOException e) { return; }
        System.out.println("and now the list...");
        list.stream()
               // reference to method
            .map(String::toUpperCase)
            .forEach(System.out::println);
    }
}
