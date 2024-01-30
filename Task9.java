public class Task9 {


    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);

        int a1 = scan.nextInt();
        int a2 = scan.nextInt();
        int a3 = scan.nextInt();

        System.out.println(a1 + ", " + a2 + ", " + a3);

        // solution 1
        int max = (a1 > a2) ? (a1 > a3 ? a1 : a3) : (a2 > a3 ? a2 : a3);
        int min = (a1 < a2) ? (a1 < a3 ? a1 : a3) : (a2 < a3 ? a2 : a3);
        int mid = (a1 < max && a1 > min) ? a1 : (a2 < max && a2 > min) ? a2 : a3;

        System.out.println(min + ", " + mid + ", " + max);


        // solution 2
        if (a1 > a2) {
            int tmp = a1;
            a1 = a2;
            a2 = tmp;
        }

        if (a3 < a1) {
            System.out.println(a3 + ", " + a1 + ", " + a2);
        } else {
            if (a3 > a2) {
                System.out.println(a1 + ", " + a2 + ", " + a3);
            } else {
                System.out.println(a1 + ", " + a3 + ", " + a2);
            }
        }


    }
}
