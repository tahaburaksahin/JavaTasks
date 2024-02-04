// LUS-Intern/MyBundle_fr.java
 
import javax.swing.ImageIcon;
import java.util.ListResourceBundle;

  // must be public
public class MyBundle_fr extends ListResourceBundle {
    public Object[][] getContents() {
        return contents;
    }
    private Object[][] contents = {
        { "hello", "Salut"                    },
        { "today", "aujourd\'hui nous sommes" },
        { "flag",  new ImageIcon("france.gif")    },
    };
}
