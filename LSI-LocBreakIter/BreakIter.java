// LSI-LocBreakIter/BreakIter.java
 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.Locale;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import static javax.swing.JDialog.DISPOSE_ON_CLOSE;

public class BreakIter {

    public static void main(String[] args) {
        new BreakIter();
    }

    BreakIter() {
        int   start, end;
        BreakIterator bi;
        String      text;
        StringBuilder sb = new StringBuilder(1000);

        // Greek text - words
        text = readText("iliad_el.txt","UTF-8");
        bi = BreakIterator.getWordInstance(
                     new Locale("el","GR"));
        bi.setText(text);

        start = bi.first();
        end   = bi.next();
        while (end != BreakIterator.DONE) {
            String word = text.substring(start,end);
            start = end;
            end   = bi.next();
            if (!Character.isLetter(word.charAt(0)))
                continue;
            sb.append(word+'\n');
        }
        showText(sb.toString());
        sb.setLength(0);

        // Russian text - sentences
        text = readText("pushkin_ru.txt","UTF-8");
        bi = BreakIterator.getSentenceInstance(
                         new Locale("ru","RU"));
        bi.setText(text);

        start = bi.first();
        end   = bi.next();
        while (end != BreakIterator.DONE) {
            String sentence = text.substring(start,end);
            sentence = sentence.replaceAll("\\n"," ");
            start = end;
            end   = bi.next();
            sb.append(sentence+'\n');
        }
        showText(sb.toString());
    }

    private String readText(String file, String enc) {
        StringBuilder sb = new StringBuilder(1000);
        try {
            BufferedReader fr =
                new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream(file),enc));
            String line;
            while( (line = fr.readLine()) != null )
                sb.append(line+'\n');
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return sb.toString();
    }

    private void showText(String text) {
        final JDialog dialog = new JDialog();
        dialog.add(
            new JScrollPane(new JTextArea(text)));
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                dialog.pack();
                dialog.setVisible(true);
            }
        });
    }
}
