// LUS-Intern/Intern.java
 
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class Intern {

    private static ResourceBundle bundle;

    public static void main(String[] args) {
        String[] opts = {"pl","en","fr"};
        int ans =
            JOptionPane.showOptionDialog(null,
                "Select a language",
                "Language selection",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,opts,opts[1]);
        if (ans == JOptionPane.CLOSED_OPTION)
            System.exit(0);

        Locale loc = new Locale(opts[ans]);
        bundle = ResourceBundle.getBundle(
                           "MyBundle",loc);

        SimpleDateFormat df = (SimpleDateFormat)
            DateFormat.getDateInstance(DateFormat.FULL,loc);

        String hello = bundle.getString("hello"),
               today = bundle.getString("today"),
               data = df.format(Calendar.getInstance().
                                            getTime());
        ImageIcon icon =
                    (ImageIcon)bundle.getObject("flag");

        JOptionPane.showMessageDialog(null,
                hello+ ", " + today + ": " + data,"I18N",
                JOptionPane.INFORMATION_MESSAGE,icon);

        System.exit(0);
    }
}
