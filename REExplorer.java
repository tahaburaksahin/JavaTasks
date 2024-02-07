// GXW-REExplorer/REExplorer.java
 
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import static javax.swing.JDialog.DISPOSE_ON_CLOSE;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class REExplorer {

    public static void main(String[] args) {
        new REExplorer();
    }

    private REExplorer() {
        final JFrame f = new JFrame("RE Explorer");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        final JLabel labx = new JLabel("REGEX:");
        final JTextField rege = new JTextField(40);
        final JButton gobu  = new JButton("Go!");
        labx.setFont(new Font("Dialog",Font.PLAIN,18));
        gobu.setFont(new Font("Dialog",Font.PLAIN,18));
        rege.setFont(new Font("Dialog",Font.PLAIN,18));
        rege.setBorder(BorderFactory.
                        createEmptyBorder(5,5,5,5));
        JPanel pans = new JPanel();
        pans.setLayout(new FlowLayout());
        pans.add(labx);
        pans.add(rege);
        pans.add(gobu);

        final JTextArea text = new JTextArea(10,40);
        text.setFont(new Font("Dialog",Font.PLAIN,18));
        text.setBorder(BorderFactory.
                       createTitledBorder(
                       "Enter text to be searched below"));

        AbstractAction act = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showText(getMatches(rege.getText(),
                                    text.getText()));
            }
        };
        rege.addActionListener(act);
        gobu.addActionListener(act);

        JScrollPane scroll = new JScrollPane(text,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scroll,BorderLayout.CENTER);
        panel.add(pans,BorderLayout.SOUTH);

        f.setContentPane(panel);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }

    private String getMatches(String regex, String text) {
        StringBuilder sb = new StringBuilder(200);
        String nL = System.getProperty("line.separator");

        sb.append("Pattern: \"" + regex + "\"" + nL +
                  "-- Text from here -----" + nL + text +
                  nL + "-- to here ------------" + nL + nL);
          // Compiling the pattern
        Pattern pattern = null;
        try {
            pattern = Pattern.compile(regex);
        } catch (PatternSyntaxException exc) {
            sb.append(
                  "Error: " + exc.getMessage() + nL);
            return sb.toString();
        }

        Matcher matcher = pattern.matcher(text);

          // does the whole text match the pattern?
        boolean match = matcher.matches();
        sb.append("matches() gives: " +
                  (match ? "YES" : " NO") + nL + nL);
          // groups (if any)
        if (match) {
            int gr = matcher.groupCount();
            sb.append(gr + " groups:" + nL);
            for (int i = 1; i <= gr; ++i)
                sb.append("  " + i + ": " +
                          matcher.group(i) + nL);
            sb.append(nL);
        }

        matcher.reset();

          // looking for matches inside the text
        boolean found = matcher.find();
        if (!found)
            sb.append("find() didn\'t find anything" + nL);
        else
            do {
                sb.append("find() found \"" +
                    matcher.group() + "\" at " +
                    (matcher.start()+1)  + "-" +
                    matcher.end() + nL);
            } while(matcher.find());

        return sb.toString();
    }

    private void showText(String text) {
        final JDialog dg = new JDialog();
        dg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JTextArea area = new JTextArea(20,45);
        area.setText(text);
        area.setBorder(BorderFactory.
                       createEmptyBorder(10,5,10,5));
        area.setFont(new Font("Monospaced",Font.PLAIN,20));
        area.setEditable(false);
        dg.add(new JScrollPane(area));
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                dg.pack();
                dg.setLocationRelativeTo(null);
                dg.setVisible(true);
            }
        });
    }
}
