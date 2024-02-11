// ELU-FInter/FInter.java
 
@FunctionalInterface
interface Calc {
    boolean test(Double d);
}

@FunctionalInterface
interface Cons {
    void consume(Object ob);
}

public class FInter {
    public static void main (String[] args) {
        double mn = 0, mx = 10; // effectively final
        Calc[] arr = {
            d -> d <  0,        // type of d inferred
            d -> d >= 0,
            d -> mn <= d && d <= mx
        };

        Cons cons = ob -> System.out.print(ob + " ");

        for (double d = -2; d < 15; d += 5) {
            for (Calc calc : arr)
                cons.consume(calc.test(d));
            System.out.println();
        }
    }
}
