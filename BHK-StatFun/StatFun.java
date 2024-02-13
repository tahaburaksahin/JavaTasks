// BHK-StatFun/StatFun.java
 
public class StatFun {

    static boolean isPrime(int n) {
        n = n >= 0 ? n : -n;
        if (n <= 1) throw new IllegalArgumentException();
        if (n <= 3) return true;
        if (n%2 == 0) return false;
        boolean res = true;
        for (int p = 3; p*p <= n && res; p += 2)
            if (n%p == 0) res = false;
        return res;
    }

    static void primesBetween(int a, int b) {
        for (int num = a; num <= b; ++num) {
            boolean prime = isPrime(num);
            System.out.println(num + " is " +
                (prime ? "" : "NOT ") + "prime");
        }
    }

    public static void main (String[] args) {
        int c = 2;
        primesBetween(c, 20);
    }
}
