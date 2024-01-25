// FUB-Annotat/Annot.java
// taha burak sahin pjatk

import java.awt.GridLayout;
import java.awt.Color;
import java.lang.reflect.Field;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Annot extends JFrame {

    @ButProps(panel=1,red=0,message="But1")
    JButton b1 = new JButton();

    @ButProps(panel=0,red=0,blue=255,message="But2")
    JButton b2 = new JButton();

    @ButProps(panel=0,green=0,message="But3")
    JButton b3 = new JButton();

    @ButProps(panel=1,green=0,blue=255,message="But4")
    JButton b4 = new JButton();

    public static void main(String[] args) {
        final Annot a = new Annot();
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                a.pack();
                a.setVisible(true);
            }
        });
    }

    public Annot() {
        super("Annotations");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1,5,5));
        JPanel[] panels = {new JPanel(), new JPanel()};
        configure(panels);
        add(panels[0]);
        add(panels[1]);
    }

    private void configure(JPanel[] panels) {
        Class thisClass = getClass();
        for (Field f : thisClass.getDeclaredFields()) {
            ButProps ann = f.getAnnotation(ButProps.class);

            if (ann == null) continue;

            System.err.println("\nField     : " +
                    f.getName() +"\nAnnotation: " + ann);

            JButton b = null;
            try {
                b = (JButton)f.get(this);
            } catch(IllegalAccessException e) {
                e.printStackTrace();
                System.exit(1);
            }
            b.setBackground(new Color(ann.red(),
                                      ann.green(),
                                      ann.blue()));
            b.setText(ann.message());
            panels[ann.panel()].add(b);
        }
    }
}
