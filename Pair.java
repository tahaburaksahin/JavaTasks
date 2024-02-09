// GMA-GenerPair/Pair.java
 
import java.lang.reflect.Method;

public class Pair<F, S> {
    private static int count = 0;
    private F first;
    private S second;
    public Pair(F f, S s) {
        count++;
        first  = f;
        second = s;
    }
    public F getFirst()  {return first; }
    public S getSecond() {return second;}
    public void setFirst(F f)  {first  = f;}
    public void setSecond(S s) {second = s;}
    public String toString() {return first + " " + second;}

    public static void main(String[] args) throws Exception {
        Pair<String, Integer> p1 = new Pair<>("A",1);
        Pair<String, String>  p2 = new Pair<>("C", "D");

          // what are the dynamic types of p1 and p2 ?
        System.out.println("Class of p1: " + p1.getClass() +
                "; Class od p2: " + p2.getClass());

          // method signatures
        for (Method m : p1.getClass().getDeclaredMethods())
            if (!m.getName().equals("main"))
                System.out.println(m); // type erasure

          // only one static member 'count'
        System.out.println(p1.count + " " + p2.count);

          // casting not needed, autoboxing int -> Integer
        p1.setSecond(2);

          // automatic unboxing Integer -> int
        int i = p1.getSecond();

          // no casting, must be a String
        String s = p2.getFirst();

        System.out.println("p1.second = " + i);
        System.out.println("p2.first  = " + s);
    }
}
