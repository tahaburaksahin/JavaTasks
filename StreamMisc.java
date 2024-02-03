// LDD-StreamMisc/StreamMisc.java
 
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.regex.Pattern;

public class StreamMisc {
    public static void main(String[] args) {
        System.out.println("*From an arrray...");
        String[] ws = {"To", "be", "or", "not", "to", "be"};
        Stream.of(ws)
         .map(String::toLowerCase)
         .distinct()
         .sorted()
         .forEach(e -> System.out.print(e + " "));
        System.out.println();

        System.out.println("*From varargs...");
        System.out.println(
            Stream.of("To", "be", "or", "not", "to", "be")
             .collect(Collectors.joining(" - "))
        );

        System.out.println("*From a collection...");
        List<String> list = Arrays.asList(
                    "1","10","100","1000","10000","100000");
        System.out.println("Sum = " +
            list.stream().mapToInt(Integer::parseInt).sum()
        );

          // generating a stream by iterating a unary
          // function starting from a given seed
        System.out.println("*From a generator...");
        ArrayList<Integer> arri = new ArrayList<>();
        IntStream.iterate(17, n -> n%2 == 0 ? n/2 : 3*n+1)
         .peek(arri::add)         // arri in closure,
         .allMatch(n -> n != 1);  // allMatch is short-
                                  // circuited, so will
        System.out.println(arri); // stop iteration!

        System.out.println("*Lines of a file as stream...");
        try (BufferedReader br = Files.newBufferedReader(
                    Paths.get("StreamMisc.java"),
                    StandardCharsets.UTF_8)) // default
        {
            br.lines()
             .filter(e -> e.contains("collect"))
             .forEach(System.out::println);
        } catch (IOException never_ignore_exceptions) { }

        System.out.println("*From a regex...");
        String s = "a is 1, b=3 and c:7 X";
        System.out.println("Sum of extracted numbers is " +
                Pattern.compile("\\D+")
                 .splitAsStream(s)
                 .filter(e -> e.length() > 0)
                 .mapToInt(Integer::parseInt).sum());
    }
}
