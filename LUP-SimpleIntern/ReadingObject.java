// LUP-SimpleIntern/ReadingObject.java
 
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ReadingObject {
    public static void main(String[] args) {

          // reading object MyPanel and its graph from disk
        MyPanel myPanel=null;
        try {
            XMLDecoder decoder =
                new XMLDecoder(
                    new BufferedInputStream(
                        new FileInputStream("panel.xml")));
            myPanel = (MyPanel)decoder.readObject();
            decoder.close();
        } catch(IOException e) {
            System.out.println("Something wrong");
            System.exit(1);
        }

          // checking the graph of the panel
        JButton button = myPanel.getButton();
        ActionListener[] actions =
                button.getActionListeners();
        System.out.println("Listener class       : " +
                        actions[0].getClass().getName());
        System.out.println("Text on the button   : " +
                        button.getText());
        System.out.println("Color of the panel   : " +
                        myPanel.getBackground());
        System.out.println("Dict.: " + myPanel.getMap());

          // displaying the panel read from disk
        final JFrame fr = new JFrame("Dictionary");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setContentPane(myPanel);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                fr.pack();
                fr.setVisible(true);
            }
        });
    }
}
