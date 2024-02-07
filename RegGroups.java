// GXX-RegGroups/RegGroups.java
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegGroups {
    public static void main (String[] args) {
        String str = "12-07-2014 xx 6-6-2010 yy 1-11-2011";
        String pat1 = "(\\d{1,2})-" +
                      "(\\d{1,2})-" +
                      "(\\d{4})";
        String pat2 = "(?<day>\\d{1,2})-" +
                      "(?<month>\\d{1,2})-" +
                      "(?<year>\\d{4})";

        Matcher m = Pattern.compile(pat1).matcher(str);
        System.out.println("Unnamed groups");
        while (m.find()) {
            System.out.println(m.groupCount()+" groups:");
            System.out.print("D: "+m.group(1)+", ");
            System.out.print("M: "+m.group(2)+", ");
            System.out.print("Y: "+m.group(3)+'\n');
        }

        m = Pattern.compile(pat2).matcher(str);
        System.out.println("Named groups");
        while (m.find()) {
            System.out.println(m.groupCount()+" groups:");
            System.out.print("D: "+m.group("day")+", ");
            System.out.print("M: "+m.group("month")+", ");
            System.out.print("Y: "+m.group("year")+'\n');
        }
    }
}
