// LDG-MethRefStr/MethRefStr.java
 
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethRefStr {
    public static void main(String[] args) {
        Random r = new Random(); // effectively final
        System.out.println(
                  // Supplier of double's expected
                DoubleStream.generate(r::nextGaussian)
                  // we want just ten million numbers
               .limit(10_000_000)
                  // reduction to DoubleSummaryStatistics
               .summaryStatistics()
                  // arithmetic average of all numbers
               .getAverage());

        System.out.println(
            Stream.of(new Person("C"), new Person("A"),
                      new Person("D"), new Person("B"))
                     // Function<Person,otherType> expected
                  .map(Person::getName)
                  .sorted()
                     // Function<String,otherType> expected
                  .map(String::toLowerCase)
                     // reduction to a single String
                  .collect(Collectors.joining("-")));

        Thread t = new Thread(MethRefStr::fibos);
        t.start();
        try {
            t.join();
        } catch(InterruptedException ignore) { }
    }

    public static void fibos() {
        StringBuilder sb = new StringBuilder("0, 1");
        int a = 0, b = 1;
        for (int i = 0; i < 8; ++i) {
            b += a;
            a  = b - a;
            sb.append(", " + b);
        }
        System.out.println(sb);
    }
}

class Person {
    private String name;
    public Person(String n) { name = n; }
    public String getName() { return name; }
}
