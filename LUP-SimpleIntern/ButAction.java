// LUP-SimpleIntern/ButAction.java
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButAction implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        System.err.println("Button pressed");
        System.exit(0);
    }
}
