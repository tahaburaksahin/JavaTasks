// LUS-Intern/MyBundle_pl.java
 
import javax.swing.ImageIcon;
import java.util.ListResourceBundle;

  // must be public
public class MyBundle_pl extends ListResourceBundle {
    public Object[][] getContents() {
        return contents;
    }
    private Object[][] contents = {
        { "hello", "Cze\u015b\u0107"          },
        { "today", "dzi\u015b jest"           },
        { "flag",  new ImageIcon("poland.gif")    },
    };
}
