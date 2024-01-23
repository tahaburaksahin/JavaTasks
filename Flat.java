// LDI-FlatMap/Flat.java
//taha burak sahin pjatk 

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Flat {
    public static void main(String[] args) {
        String result = null;
        try (Stream<String> stream =
                Files.lines(Paths.get("Flat.java"),UTF_8))
        {
            result =
                stream
               .flatMap(l -> Stream.of(l.split("\\P{L}+")))
               .filter(w -> w.length() > 9)
               .distinct()
               .sorted(Comparator.comparing(
                                String::length).reversed())
               .collect(Collectors.joining(", "));
        } catch(IOException ignore) { }
        System.out.println(result);
    }
}
