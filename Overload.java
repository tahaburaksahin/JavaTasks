// AFM-Overload/Overload.java
//taha burak sahin pjatk 

public class Overload {
    static int sum(int a, int b) {
        return a + b;
    }
    static int sum(int a, int b, int c) {
        return a + b + c;
    }
    static String sum(String s, int a) {
        return s + a;
    }
    public static void main (String[] args) {
        int a = 4, b = 3, c = 5;
        String s = "a=";
        System.out.println(
                "Sum of   a,b: " + sum(a, b) +
              "\nSum of a,b,c: " + sum(a, b, c) +
              "\nSum of   s,a: " + sum(s,a));
    }
}
