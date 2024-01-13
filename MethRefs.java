// LCP-MethRefs/MethRefs.java

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MethRefs {
    List<String> list = Arrays.asList(
            "Zoe", "kate", "Cindy", "barbra");
    public static void main(String[] args) {
        new MethRefs();
    }

    public MethRefs() {
        // case anObject::nonstaticMethod
        // Iterable<String> expected
        Iterable<String> iterObj = this::getIter;
        for (String s : iterObj) System.out.print(s + " ");
        System.out.println();

        // case AClass::staticMethod
        // Runnable expected
        Thread t = new Thread(MethRefs::tenFibos);
        t.start();
        try {
            t.join();
        } catch(InterruptedException ignore) { }

        // case AClass::nonstaticMethod
        // Comparator<String> expected
        Collections.sort(list, String::compareTo);
        System.out.println(list);
        Collections.sort(list, String::compareToIgnoreCase);
        System.out.println(list);
    }

    public static void tenFibos() {
        // prints first 10 Fibonacci numbers
        StringBuilder sb = new StringBuilder("0, 1");
        int a = 0, b = 1;
        for (int i = 0; i < 8; ++i) {
            b += a;
            a  = b - a;
            sb.append(", " + b);
        }
        System.out.println(sb);
    }

    public Iterator<String> getIter() {
        return list.iterator();
    }
}
