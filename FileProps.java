// KEF-FileProps/FileProps.java
// Taha Burak Sahin PJATK

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileProps {

    public static void main(String[] args) {
        // just to show how a file can be selected...
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter =
                new FileNameExtensionFilter(
                        "Programs","java", "cpp","c","py");
        chooser.setFileFilter(filter);
        int ret = chooser.showOpenDialog(null);
        if(ret != JFileChooser.APPROVE_OPTION) {
            System.out.println("No file chosen...");
            System.exit(1);
        }
        File file = chooser.getSelectedFile();
        getFileProps(file);
    }

    static private void getFileProps(File file) {
        System.out.print("File "  + file +
                "\nexists:          " + file.exists() +
                "\nisfile:          " + file.isFile() +
                "\nisDirectory:     " + file.isDirectory() +
                "\ncanRead:         " + file.canRead() +
                "\ncanWrite:        " + file.canWrite() +
                "\ncanExecute:      " + file.canExecute() +
                "\ngetName:         " + file.getName() +
                "\ngetAbsolutePath: " + file.getAbsolutePath() +
                "\ngetParent:       " + file.getParent() +
                "\nlength:          " + file.length() +
                "\nlastModified:    " + file.lastModified());
        long t = file.lastModified();
        System.out.printf(", i.e., %td %1$tB, %1$tY\n",t);
    }
}
