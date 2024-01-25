// EQA-AbstractFigs/Main.java
// taha burak sahin pjatk

import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
          // to have decimal point instead of a comma...
        Locale.setDefault(Locale.US);

        Figure[] figs = {
            new Circle(2),      new Rectangle(9,1),
            new Rectangle(4,3), new Circle(4)
        };

        Figure fig = Figure.getFigMaxArea(figs);
        System.out.println("\nLargest area: \n" + fig);

        Arrays.sort(figs);
        System.out.println("\nSorted by circumference:");
        for (Figure f : figs)
            System.out.println(f);
    }
}
