// GXY-RegFind/RegFind.java
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegFind {
    public static void main (String[] args) {

        spl("Joe : Mary::Jane", ":");
        spl("Joe : Mary:Jane", "\\s*:\\s*");

        mat("Joe : Mary:Jane", "[^:]*(:[^:]*){2}");
        mat("123 xxx ABCD", "\\.*\\d+[^A-Z]*[A-Z]{3,}");
        mat("Jane Crawford", "\\w+\\s+([A-Z]\\.)?\\s*\\w+");

        rep("a   b   c", "\\s+", " ");

        process("kot\\b",
                "Kot kot kotek");
        process("(kot)",
                "Kot kot kotek");
        process("\\b[A-Z][a-z]+\\b",
                "cat Dog hen Cow aHorse Z");
        process("^.*(kot).*(tek)",
                "Kot kot kotek");
        process("(a.*)(\\w).*",
                "a b c d c b x");
        process("(\\d{1,3}\\.){3}\\d{1,3}",
                " 1.1.1.2 12.12.34.231 234 xx 3.21.21.21 zz");
    }

    private static void process(String reg, String str) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        System.out.println("== match and find =======");
        System.out.println("STRING : " + str);
        System.out.println("REGEX  : " + reg);
        boolean gr = m.matches();
        System.out.println("Matches: " + gr);
        if (gr) {
            System.out.println("Groups : " + m.groupCount());
            for (int i = 1; i <= m.groupCount(); ++i) {
                System.out.println("Group " + i +
                           " = '" + m.group(i) + "'");
            }
        }
        m.reset();
        while (m.find()) {
            System.out.println(
                    "Found  " + ": " + m.group() +
                    " at " + m.start() + "-" + m.end());
        }
    }

    private static void spl(String str, String reg) {
        System.out.println("== split ================");
        System.out.println("STRING : " + str);
        System.out.println("REGEX  : " + reg);
        String[] s = str.split(reg);
        System.out.print(s.length + " terms:");
        for (int i = 0; i < s.length; ++i)
            System.out.print(" '" + s[i]+ "'");
        System.out.println();
    }

    private static void mat(String str, String reg) {
        System.out.println("== matches ==============");
        System.out.println("STRING : " + str);
        System.out.println("REGEX  : " + reg);
        System.out.println(str.matches(reg));
    }

    private static void rep(String str, String reg, String with) {
        System.out.println("== replace ==============");
        System.out.println("STRING : " + str);
        System.out.println("REGEX  : " + reg);
        System.out.println("WITH   : '" + with + "'");
        System.out.println(str.replaceAll(reg,with));
    }
}
