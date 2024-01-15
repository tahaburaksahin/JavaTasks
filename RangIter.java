// JIX-RangIter/RangIter.java
// Taha Burak Sahin PJATK

import java.util.Iterator;
import java.util.NoSuchElementException;

// main class for testing
public class RangIter {
    public static void main (String[] args) {
        Iterable<Integer> iterab1 = new IterableRange(3,7);
        Iterator<Integer> iter = iterab1.iterator();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");

        System.out.println("\nand now foreach:");
        for (Integer i : new IterableRange(3,7))
            System.out.print(i + " ");
        System.out.println();
    }
}

// objects of this class are 'iterable', i.e., they
// behave (at least to some extend) as collections
class IterableRange implements Iterable<Integer> {
    private int a, b;
    IterableRange(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public Iterator<Integer> iterator() {
        return new RangeIterator(a,b);
    }
}

// object of this class bahave like interators
// traversing the IterableRange 'collections'
class RangeIterator implements Iterator<Integer> {
    private int a, b;
    private int curr;
    RangeIterator(int a, int b) {
        this.a = a;
        this.b = b;
        curr = a;
    }
    @Override
    public boolean hasNext() {
        return curr <= b;
    }
    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        return curr++;
    }
    // since Java 1.8 remove has a default implementation
}
