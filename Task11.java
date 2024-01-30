public class Task11 {

    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);

        int a1 = scan.nextInt();
        int a2 = scan.nextInt();
        int a3 = scan.nextInt();
        int a4 = scan.nextInt();

        int max;
        int min;

//        bad solution
        if (a1 > a2) {
            if (a1 > a3) {
                if (a1 > a4) {
                    max = a1;
                } else {
                    max = a4;
                }
            } else {
                if (a3 > a4) {
                    max = a3;
                } else {
                    max = a4;
                }
            }
        } else {
            if (a2 > a3) {
                if (a2 > a4) {
                    max = a2;
                } else {
                    max = a4;
                }
            } else {
                if (a3 > a4) {
                    max = a3;
                } else {
                    max = a4;
                }
            }
        }

//        the best solution
        max = a1;
        if (max < a2) max = a2; // ==  if (max < a2){ max = a2;}
        if (max < a3) max = a3;
        if (max < a4) max = a4;
        min = a1;
        if (min > a2) min = a2;
        if (min > a3) min = a3;
        if (min > a4) min = a4;

        System.out.println(min);
        System.out.println(max);
        System.out.println("odp: " + (max - min));


    }
}
