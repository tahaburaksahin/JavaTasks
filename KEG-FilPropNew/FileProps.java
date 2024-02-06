// KEG-FilPropNew/FileProps.java
 
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileProps {

    public static void main(String[] args)
                            throws IOException {
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
        Path path = file.toPath();
        getPathProps(path);
    }

    static private void getPathProps(Path path)
                                     throws IOException {
        System.out.print("File " + path +
            "\nexists:        "+Files.exists(path) +
            "\nisRegularFile: "+Files.isRegularFile(path) +
            "\nisDirectory:   "+Files.isDirectory(path) +
            "\nisReadable:    "+Files.isReadable(path) +
            "\nsize:          "+Files.size(path));
        FileTime t = Files.getLastModifiedTime(path);
        System.out.printf("\nLast modified: " + t);
        System.out.printf(", i.e., %td %1$tB %1$tY\n",
                                        t.toMillis());
    }
}
