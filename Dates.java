// LSE-LocFmtDates/Dates.java
//taha burak sahin pjatk 

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

public class Dates {

    public static void main(String[] args) {

        SimpleDateFormat dinp =
            (SimpleDateFormat)DateFormat.getDateInstance();
        dinp.applyPattern("y M d");

        SimpleDateFormat doEn =
            (SimpleDateFormat)DateFormat.getDateInstance(
                          DateFormat.SHORT,Locale.US);
        SimpleDateFormat doFr =
            (SimpleDateFormat)DateFormat.getDateInstance(
                          DateFormat.SHORT,Locale.FRANCE);
        SimpleDateFormat doPl =
            (SimpleDateFormat)DateFormat.getDateInstance(
                      DateFormat.SHORT,new Locale("pl"));
        SimpleDateFormat doGr =
            (SimpleDateFormat)DateFormat.getDateInstance(
                  DateFormat.FULL,new Locale("el","GR"));

        doEn.applyPattern("EEEE, d 'of' MMMM',' yyyy G");
        doFr.applyPattern("yyyy'/'MM'/'dd' ('EEEE')'");
        doPl.applyPattern("'Ten dzie\u0144 to 'EEEE',' d "+
                          "MMMM yyyy' r.'");

        while (true) {
            String s = JOptionPane.showInputDialog(null,
                "Enter a date as \'y m d\'",
                "Enter a date",
                JOptionPane.QUESTION_MESSAGE);
            if (s == null || s.length() == 0) break;

            Date d = dinp.parse(s,new ParsePosition(0));

            JOptionPane.showMessageDialog(null,
                "<html>" + doEn.format(d)+
                "<br />" + doFr.format(d)+
                "<br />" + doPl.format(d)+
                "<br />" + doGr.format(d),
                "Date",JOptionPane.INFORMATION_MESSAGE);
        }
        System.exit(0);
    }
}
