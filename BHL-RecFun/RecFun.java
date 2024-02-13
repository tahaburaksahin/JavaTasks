// BHL-RecFun/RecFun.java
 
public class RecFun {

    static int fact(int n) {
        if (n < 0) throw new IllegalArgumentException();
        if (n <= 1) return 1;
        return n*fact(n-1);
    }

    public static void main (String[] args) {
        for (int num = 0; num <= 12; ++num)
            System.out.println("Factorial of " + num +
                               " is " + fact(num));
    }
}
