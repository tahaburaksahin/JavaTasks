// LUS-Intern/MyBundle.java
 
import javax.swing.ImageIcon;
import java.util.ListResourceBundle;

  // must be public
public class MyBundle extends ListResourceBundle {
    public Object[][] getContents() {
        return contents;
    }
    private Object[][] contents = {
        { "hello", "Hello"                    },
        { "today", "today is"                 },
        { "flag",  new ImageIcon("uk.gif")    },
    };
}
