// GXR-RegExNames/RegEx.java
 
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import static java.nio.charset.StandardCharsets.UTF_8;

/*  Reads file "input.txt" (in UTF-8) and selects
 *  names (strings starting with capital letter with
 *  other letters in lowercase. Then prints a list of
 *  names together with numbers of occurences and lists
 *  of line numbers where a given name appeared.
 *  Uses class Name.
*/
public class RegEx {

    private Map<String,Name> map;

    public static void main(String[] args) {
        new RegEx("input.txt");
        System.exit(0);
    }

    public RegEx(String fileName) {
        Path filein = Paths.get(fileName);
        if (!Files.exists(filein)     ||
            !Files.isReadable(filein) ||
             Files.isDirectory(filein)) {
            System.err.println("Invalid input file !!!");
            System.exit(1);
        }
//         File input = new File(filename);
//         BufferedReader br = null;
        map = new TreeMap<String,Name>();
        try (
            BufferedReader br =
                Files.newBufferedReader(filein, UTF_8)
            ) {
            String line, name,
                   patt = "\\b\\p{Lu}\\p{Ll}+\\b";
            Pattern pattern = null;
            try {
                pattern = Pattern.compile(patt);
            } catch(PatternSyntaxException e) {
                System.err.println("Wrong pattern");
                System.exit(1);
            }
            Matcher matcher = pattern.matcher("");

            int lineNo = 0;
            while ((line = br.readLine()) != null) {
                lineNo++;
                matcher.reset(line);
                if (matcher.find()) {
                    do {
                        name = matcher.group();
                        if (!map.containsKey(name))
                            map.put(name,
                                    new Name(name,lineNo));
                        else
                            map.get(name).addNum(lineNo);
                    } while (matcher.find());
                }
            }
        } catch(IOException e) {
            System.err.println("Something wrong - exiting");
            e.printStackTrace();
            System.exit(1);
        }

        for (Map.Entry<String,Name> e : map.entrySet())
            System.out.println(e.getValue());
    }
}
