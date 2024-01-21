// AFR-SelSort/SelSort.java
//taha burak sahin pjatk 

public class SelSort {
    private static void selSortIte(int[] a) {
        for (int i = 0; i < a.length-1; ++i) {
            int indmin = i;
            for (int j = i+1; j < a.length; ++j)
                if (a[j] < a[indmin]) indmin = j;
            int temp = a[i];
            a[i] = a[indmin];
            a[indmin] = temp;
        }
    }

    private static void selSortRec(int[] a, int from) {
        if (from == a.length-1) return;
        int indmin = from;
        for (int i = from+1; i < a.length; ++i)
            if (a[i] < a[indmin]) indmin = i;
        int temp = a[from];
        a[from] = a[indmin];
        a[indmin] = temp;
        selSortRec(a, from+1);
    }

    private static void printArray(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; ++i)
            System.out.print(" " + a[i]);
        System.out.println(" ]");
    }

    public static void main (String[] args) {
        int[] a1 = {4, 8, -3, 5, 2, 8, 4, 6};
        int[] a2 = {4, 8, -3, 5, 2, 8, 4, 6};
        selSortIte(a1);
        printArray(a1);
        selSortRec(a2, 0);
        printArray(a2);
    }
}
