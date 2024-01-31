// HUG-Lists/AList.java
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;

public class AList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Sue");
        list.add("Lea");
        list.add("Ann");
        list.add("Kim");
        list.add("Lea");
        list.add(1,"Amy");  // inefficient!

        System.out.println("First 'Lea' under index " +
                                   list.indexOf("Lea"));
        System.out.println("Last  'Lea' under index " +
                               list.lastIndexOf("Lea"));
        System.out.println("Does the list contain 'Sue': " +
                                     list.contains("Sue"));
        System.out.println("Does the list contain 'Bea': " +
                                     list.contains("Bea"));
        System.out.println("Size of list: " + list.size());

          // traditional looping
        System.out.print("With get():  ");
        for (int i = 0; i < list.size(); ++i)
            System.out.print(" " + list.get(i));
          // `foreach' loop
        System.out.print("\nAnother way: ");
        for (String s : list)
            System.out.print(" " + s);
          // iterators
        System.out.print("\nnow iterator:");
        Iterator<String> iter = list.iterator();
        while (iter.hasNext())
            System.out.print(" " + iter.next());

          // sorting and sublists
        Collections.sort(list);
        System.out.println("\nSorted:      " + list);
        List<String> subl = list.subList(1,4);
        System.out.println("Sublist:     " + subl);

          // HashSet
        Set<String> hSet = new HashSet<>(list);
        System.out.println("Hash set:    " + hSet);
          // TreeSet
        Set<String> tSet = new TreeSet<>(list);
        System.out.println("Tree set:    " + tSet);
        System.out.println("Does the tSet contain 'Sue': " +
                                     tSet  .contains("Sue"));
        tSet.add("Zoe");
        tSet.remove("Lea");
        System.out.println("tSet now:    " + tSet);
    }
}
