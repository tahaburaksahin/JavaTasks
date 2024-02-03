// LUP-SimpleIntern/MyPanel.java
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
    private Map<String,String> map;
    private JButton            button;
    private JPanel             panel;

    public Map<String,String> getMap() {
        return map;
    }
    public void setMap(Map<String,String> map) {
        this.map = map;
    }

    public JButton getButton() {
        return button;
    }
    public void setButton(JButton button) {
        this.button = button;
        add(button,BorderLayout.SOUTH);
    }

    public MyPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300,300));
        setOpaque(true);
        setBackground(Color.BLACK);
    }
}
