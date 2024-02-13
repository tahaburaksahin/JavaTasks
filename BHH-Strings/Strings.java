// BHH-Strings/Strings.java
 
public class Strings {
    private static void pr(String m, String a, String b) {
        System.out.println(m + ": \"" + a +
                     "\" -> \"" + b + "\"");
    }
    public static void main (String[] args) {
          // length()
        String a = " Shakespeare   ";
        String b = a.trim();
        System.out.println("a.length() -> " + a.length());
        System.out.println("b.length() -> " + b.length());
        pr("        trim()", a, b);

          // substring
        a = "abcdefgh";
        b = a.substring(3,6);
        pr("substring(3,6)", a, b);
        b = a.substring(3);
        pr("  substring(3)", a, b);

          // toUpperCase, toLowerCase
        b = a.toUpperCase();
        pr(" toUpperCase()", a, b);

          // split
        String[] arr = "ONE:TWO:THREE".split(":");
        for (String d : arr)
            System.out.print(d.toLowerCase() + " ");
        System.out.println();

        arr = "one   two       three".split("\\s+");
        for (String d : arr)
            System.out.print(d.toUpperCase() + " ");
        System.out.println();

          // charAt
        String ny = "New York";
        for (int i = 0; i < ny.length(); ++i)
            System.out.print(ny.charAt(i) + " ");
        System.out.println();

          // toCharArray
        char[] ca = ny.toCharArray();
        for (int i = ca.length-1; i >= 0; --i)
            System.out.print(ca[i]);
        System.out.println();

    }
}
