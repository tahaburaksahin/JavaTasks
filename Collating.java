// LRW-LocCollate/Collating.java
//taha burak sahin pjatk 

import java.text.Collator;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;

public class Collating {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "\u017baba",   "Zebra",
                "\u0179rebak","\u017b\u00f3\u0142w");

        Collections.sort(list,
                Collator.getInstance(new Locale("pl")));
        JOptionPane.showMessageDialog(null,
                "PL: "+list.toString(),"Lista",
                JOptionPane.INFORMATION_MESSAGE);

        Collections.sort(list,
                Collator.getInstance(new Locale("en")));
        JOptionPane.showMessageDialog(null,
                "EN: "+list.toString(),"Lista",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
