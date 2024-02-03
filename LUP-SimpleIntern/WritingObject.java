// LUP-SimpleIntern/WritingObject.java
 
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class WritingObject {
    public static void main(String[] args) {

        JButton button = new JButton();
        button.setText("Press me");
        button.addActionListener(new ButAction());

        Map<String,String> map =
                new HashMap<String,String>();
        map.put("chat","cat");
        map.put("chien","dog");
        map.put("cheval","horse");

        MyPanel myPanel = new MyPanel();
        myPanel.setButton(button);
        myPanel.setMap(map);

          // writing the panel and its graph
        try {
            XMLEncoder encoder =
                new XMLEncoder(
                    new BufferedOutputStream(
                        new FileOutputStream("panel.xml")));
            encoder.writeObject(myPanel);
            encoder.close();
        } catch(IOException e) {
            System.out.println("Something wrong");
            System.exit(1);
        }

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
