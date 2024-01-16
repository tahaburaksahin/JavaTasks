// ABY-RelOps/RelOps.java
// Taha Burak Sahin PJATK
public class RelOps {
    public static void main (String[] args) {
        int a = 1, b = 8, d = 8;
        System.out.println(
                "Is d in [a,b]: " +
                        ( a <= d && d <= b ));
        System.out.println(
                "Is d in (a,b): " +
                        ( a <  d && d <  b ));
        System.out.println(
                "Is d outside (a,b): " +
                        ( d <  a || d >  b ));
        System.out.println(
                "Is d outside (a,b): " +
                        ( !(d >=  a || d <=  b) ));
        System.out.println(
                "Is d == b: " + (d == b));
        System.out.println(
                "Is d != b: " + (d != b));
    }
}
