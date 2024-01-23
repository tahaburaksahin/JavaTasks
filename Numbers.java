// LSG-LocFmtNumbers/Numbers.java
//taha burak sahin pjatk 

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

public class Numbers {
    static StringBuilder sb = new StringBuilder();

    public static void addInfo(double x, String fmt) {
        DecimalFormat def = new DecimalFormat(fmt);
        DecimalFormat eng = (DecimalFormat)
                NumberFormat.getInstance(Locale.US);
        eng.applyPattern(fmt);

        sb.append("<br />Format: \"" + fmt +
                  "\"; default: " + def.format(x) +
                  "; us: " + eng.format(x));
    }

    public static void main(String[] args) {
        sb.append("<html>FORMATS:");

        addInfo(1121.76  ,"0.###");
        addInfo(1121.76  ,"0.000");
        addInfo(1121.76  ,"0.00E00");
        addInfo(  0.07677,"0.# %");
        addInfo(  0.07677,"0.00 \u2030"); // per mille
        addInfo(      257,"0.00 \u00a4"); // currency
        addInfo(      257,"0.00 \u00a4\u00a4");

        JOptionPane.showMessageDialog(
            null,sb.toString(),"Formatting numbers",
            JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
