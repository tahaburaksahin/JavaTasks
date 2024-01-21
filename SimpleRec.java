// AFL-FunRecur/SimpleRec.java
 //taha burak sahin pjatk 
public class SimpleRec {

      // should be called with from=0
    static void printArrRec(int[] arr, int from) {
        if (from == arr.length) {
            System.out.println();
            return;
        }
          // first print then invoke next
        System.out.print(arr[from] + " ");
        printArrRec(arr,from+1);
    }

      // should be called with from=0
    static void printArrRecReverse(int[] arr, int from) {
        if (from == arr.length) return;
          // first invoke next then print
        printArrRecReverse(arr,from+1);
        System.out.print(arr[from] + " ");

        if (from == 0) System.out.println();
    }

      // should be called with from=0, to=arr.length
    static void revArrayRec(int[] arr, int from, int to) {
        if (to-from <= 1) return;
        int temp = arr[from];
        arr[from] = arr[to-1];
        arr[to-1] = temp;
        revArrayRec(arr,from+1,to-1);
    }

      // should be called with from=0
    static int maxElemRec(int[] arr, int from) {
        if (from == arr.length-1) return arr[arr.length-1];
        return Math.max(arr[from],maxElemRec(arr,from+1));
    }

      // should be called with from=0
    static void selSortRec(int[] arr, int from) {
        if (from == arr.length-1) return;
        int indmin = from;
        for (int i = from+1; i < arr.length; ++i)
            if (arr[i] < arr[indmin]) indmin = i;
        int temp = arr[from];
        arr[from] = arr[indmin];
        arr[indmin] = temp;
        selSortRec(arr,from+1);
    }

    static int gcd(int a, int b) {
        return  b == 0 ? a : gcd(b, a%b);
    }

    static int fact(int n) {
        return  n <= 1 ? 1 : n*fact(n-1);
    }

      // must be called with k=2
    static boolean isPrime(int n, int k) {
        if (k*k > n)  return true;
        if (n%k == 0) return false;
        return isPrime(n,k+1);
    }

    static long counter = 0;
      // stupid way of calculating Fibonacci numbers
    static long fibo(int n) {
        ++counter;
        return n <= 1 ? (long)n : fibo(n-2) + fibo(n-1);
    }

    public static void main(String[] args) {
          // Arrays
        int[] a = {13,3,55,7,9,11};
        printArrRec(a,0);
        revArrayRec(a,0,a.length);
        printArrRec(a,0);
        selSortRec(a,0);
        printArrRec(a,0);
        printArrRecReverse(a,0);
        System.out.println("Max. in a: "+maxElemRec(a,0));

          // GCD
        System.out.println("Greatest common divisor of" +
                " 5593 and 11067 is " + gcd(5593,11067));

          // Factorials
        System.out.println("10! = " + fact(10));
        System.out.println("12! = " + fact(12));
          // NO ERROR BUT WRONG!!!
        System.out.println("13! = " + fact(13) + " WRONG!");

          // Primes
        System.out.println("Primes up to 100");
        for (int n = 2; n <=100; ++n)
            if (isPrime(n,2)) System.out.print(n+" ");
        System.out.println();

          // Fibonacci numbers
        for (int n = 40; n <= 46; n += 2) {
            counter = 0;
            long r = fibo(n);
            System.out.println("Fibo(" + n + ") = " + r +
                                "; counter = " + counter);
        }
    }
}
