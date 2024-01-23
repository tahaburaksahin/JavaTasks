// LRR-Locales/Locales.java
//taha burak sahin pjatk 

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Date;
import javax.swing.JOptionPane;

public class Locales {

    public static void main(String[] args) {

        // all available locales
        Locale[] allLocs = Locale.getAvailableLocales();
        System.out.println("Available locales:");
        for (Locale loc : allLocs)
            System.out.println(loc);
        System.out.println("\n");

        Locale[] locs = {
                            Locale.getDefault(),
                            Locale.US, Locale.FRANCE,
                            new Locale("cs","CZ"),
                            new Locale("no","NO","NY"),
                            new Locale("Ar","KW"),
                        };

        for (Locale loc : locs) info(loc);

        System.exit(0);
    }

    static public void info(Locale loc) {
        Locale def = Locale.getDefault();
        Locale.setDefault(loc);

        DateFormat   df =
            DateFormat.getDateInstance(DateFormat.FULL);
        NumberFormat nf = NumberFormat.getInstance();

        StringBuilder sb = new StringBuilder();
        sb.append("<html>Locale: " + loc + " " +
                  loc.getDisplayCountry() + " (" +
                  loc.getDisplayCountry(Locale.US) +
                  ")<br />");
        sb.append("Date: "+df.format(new Date())+"<br />");
        sb.append("Number: " + nf.format(987654.321));

        JOptionPane.showMessageDialog(
            null,sb.toString(),"Locale info",
            JOptionPane.INFORMATION_MESSAGE);

        Locale.setDefault(def);
    }
}
