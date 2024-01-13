// LDA-Streams/Streams.java
// Taha burak sahin PJATK.
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

enum HairColor { BLACK, BROWN, BLOND, RED, WHITE };
enum EyeColor  { AMBER, BLUE, BROWN, GRAY, GREEN, HAZEL };
enum Sex       { WOMAN, MAN };

public class Streams {
    public static void main(String... aargs) {
        System.out.println("*Sorting by length of name");
        Stream.of("Alice", "Margot", "Mary", "Sue")
                .sorted((a,b) ->
                        Integer.compare(a.length(),b.length()))
                .forEach(System.out::println);

        System.out.println("*Summing ints...");
        int sum = IntStream.of(3,2,9,12,8,4)
                .filter(n -> n%2 == 0)
                .map(n -> 3*n+1)
                .sorted()
                .peek(n -> System.out.print(n+" "))
                .sum();
        System.out.println("\nSum = " + sum);

        List<Person> listp = Arrays.asList(
                new Person("Ann",Sex.WOMAN,
                        HairColor.BLOND,EyeColor.BLUE),
                new Person("Joe",Sex.MAN,
                        HairColor.BLACK,EyeColor.BROWN),
                new Person("Sue",Sex.WOMAN,
                        HairColor.RED,EyeColor.HAZEL),
                new Person("Ben",Sex.MAN,
                        HairColor.BROWN,EyeColor.GREEN),
                new Person("Bea",Sex.WOMAN,
                        HairColor.WHITE,EyeColor.GRAY)
        );

        System.out.println("*Women's names...");
        String womenNames =
                listp.stream()
                        .filter(p -> p.getSex() == Sex.WOMAN)
                        .map(Person::getName)
                        .collect(Collectors.joining(", "));
        System.out.println("Women: " + womenNames);

        System.out.println("*Counting men...");
        long menCount =
                listp.stream()
                        .filter(p -> p.getSex() == Sex.MAN)
                        .count();
        System.out.println("No. of men: " + menCount);

        System.out.println("*Names staring with 'B'");
        String nameB =
                listp.stream()
                        .filter(p -> p.getName().charAt(0) == 'B')
                        .map(Object::toString)
                        .collect(Collectors.joining("\n"));
        System.out.println(nameB);
    }
}

class Person {
    private final String    name;
    private final Sex       sex;
    private final HairColor hairColor;
    private final EyeColor  eyeColor;
    public Person(String n, Sex g,
                  HairColor hc, EyeColor ec) {
        name      =  n;
        sex       =  g;
        hairColor = hc;
        eyeColor  = ec;
    }
    public String getName() { return name; }
    public Sex    getSex() { return sex; }
    public HairColor getHairColor() { return hairColor; }
    public EyeColor getEyeColor() { return eyeColor; }

    @Override
    public String toString() {
        return (sex == Sex.WOMAN ? "Mrs " : "Mr ") +
                name + " (hair:" + hairColor + ", eyes:" +
                eyeColor + ")";
    }
}
