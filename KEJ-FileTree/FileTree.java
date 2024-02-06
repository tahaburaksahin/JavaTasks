// KEJ-FileTree/FileTree.java
 
import java.io.File;

public class FileTree {

    public static void main(String[] args) {
        File file = (args.length == 0) ?
              new File(System.getProperty("user.dir")).
                       getParentFile().getParentFile()
            : new File(args[0]);
        getList(file,"");
    }

    private static void getList(File dir, String skip) {

          // indentation
        System.out.print(skip);

        System.out.println("[" + dir.getName() + "]");
        skip = skip + "    ";
          // list of files from a directory
        File[] lis = dir.listFiles();
        for (File file : lis) {
            if (file.isFile()) {
                System.out.print(skip);
                System.out.println(" " + file.getName());
            }
        }
          // go recursively into directories
        for (File file : lis)
            if (file.isDirectory())
                getList(file,skip);
    }
}
