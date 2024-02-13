// CYD-BasicArray/BasicArr.java
 
public class BasicArr {

    public static void main(String[] args) {
        int[] a1 = {1,2,3};
        printArr(a1, "Array a1");

        int[] a2;  //  <-- no array here, only reference!
        a2 = new int[]{4,5,6};
        printArr(a2, "Array a2");

        a1 = a2;   // <-- whatever was in a1 is lost!
        printArr(a1, "After a1=a2, a1 is");

          // a1 and a2 now refer to the same array!
        a1[0] = 44;
        a2[2] = 66;
        printArr(a1, "After modifications a1 is");
        printArr(a2, "After modifications a2 is");

          // ad hoc array
        printArr(new int[]{7,8,9}, "Ad hoc array");
    }


    /**
     *  prints an array of integer numbers
     */
    private static void printArr(int[] a, String message) {
        System.out.print(message + ": [");
        for (int i : a)
            System.out.print(" " + i); // <-- i unmodifiable
        System.out.println(" ]; size = " + a.length);
    }
}
