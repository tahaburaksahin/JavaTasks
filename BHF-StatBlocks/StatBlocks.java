// BHF-StatBlocks/StatBlocks.java
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

import static java.nio.charset.StandardCharsets.UTF_8;

public class StatBlocks {
    static private double rateUSD = 1;
    static private double rateUAH = 1;

      // static initializer block
    static {
        try {
            URL nbp = new URL(
                "http://www.nbp.pl/kursy/xml/LastA.xml");
            BufferedReader bw =
                new BufferedReader(
                    new InputStreamReader(
                        nbp.openStream(),UTF_8));
            String txt =
                bw.lines().collect(Collectors.joining(" "));
            bw.close();
            Matcher m =
                Pattern.compile(".*USD.*?(\\d+,\\d+)" +
                                ".*UAH.*?(\\d+,\\d+).*")
                       .matcher(txt);
            m.matches();
            rateUSD = Double.parseDouble(
                         m.group(1).replace(",","."));
            rateUAH = Double.parseDouble(
                         m.group(2).replace(",","."));
        } catch (Exception e) {
            if (JOptionPane.showConfirmDialog(
                    null, "Fetching data failed; continue" +
                    " anyway with default rates = 1?",
                    "WARNING! FETCHING DATA FAILED!",
                    JOptionPane.YES_NO_OPTION
                    ) != JOptionPane.YES_OPTION
               ) System.exit(1);
        }
    }

    private static int ID = 1;

    private final int id;

      // non-static initializer block
    {
        if (ID % 100 == 13) ++ID;
        id = ID++;
    }

    private double amount;

    public StatBlocks(double a) { amount = a; }
    public StatBlocks()         { this(20);   }

    public static double getRateUSD() { return rateUSD; }
    public static double getRateUAH() { return rateUAH; }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "My id = %d. I have %5.2f " +
                "PLN = $%5.2f = %6.2f UAH",id,
                amount, amount/rateUSD,amount/rateUAH);
    }

    public static void main (String[] args)
                          throws Exception {
        double rUSD = StatBlocks.getRateUSD();
        System.out.println("Current rates are:\n" +
            "    USD/PLN = " + rateUSD + '\n' +
            "    UAH/PLN = " + rateUAH);
        StatBlocks sa = new StatBlocks();
        StatBlocks sb = new StatBlocks(40);
        StatBlocks sc = new StatBlocks(80);
        System.out.println(sc + "\n" + sb + "\n" + sa);
    }
}
