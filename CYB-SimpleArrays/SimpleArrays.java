// CYB-SimpleArrays/SimpleArrays.java
 
public class SimpleArrays {
    public static void main(String[] args) {

        // ================================================
        int[] a = {1,2,3};
        System.out.println("a.length = " + a.length);
        for (int i = 0; i < a.length; ++i)
            a[i] = (i+1)*(i+1);
        for (int i = 0; i < a.length; ++i)
            System.out.print(a[i]+" ");
        System.out.println('\n');

        // ================================================
        int[][] b = { {1,2,3}, {4,5,6,7,8}, {11,12} };
        System.out.println("b.length = " + b.length);
        for (int row = 0; row < b.length; ++row)
            System.out.println("b["+row+"].length = " +
                                         b[row].length);
        System.out.println();

        for (int row = 0; row < b.length; ++row) {
            for (int col = 0; col < b[row].length; ++col)
                System.out.print(b[row][col]+" ");
            System.out.println();
        }
        System.out.println('\n');

        // ================================================
        int[] c = new int[]{1,2,3}; // <- size inferred
        System.out.println("c.length = " + c.length);
        for (int i = 0; i < c.length; ++i)
            System.out.print(c[i]+" ");
        System.out.println('\n');

        // ================================================
        int[] d = new int[5];       // <- elements are 0
        System.out.println("d.length = " + d.length);
        for (int i = 0; i < d.length; ++i)
            System.out.print(d[i]+" ");
        System.out.println('\n');

        // ================================================
        int[][] e = new int[3][2];  // <- a 3x2 matrix
        System.out.println("e.length = " + e.length);
        for (int row = 0; row < e.length; ++row)
            for (int col = 0; col < e[row].length; ++col)
                e[row][col] = row+col;

        // ================================================
        int[][] f = new int[3][];
        for (int row = 0; row < f.length; ++row)
            System.out.print(f[row]+" ");
        System.out.println();

        for (int row = 0; row < f.length; ++row)
            f[row] = new int[row*row+2];

        for (int row = 0; row < f.length; ++row) {
            System.out.println("f["+row+"].length = " +
                                         f[row].length);
            for (int col = 0; col < f[row].length; ++col)
                f[row][col] = row+col;
        }
        System.out.println();

        for (int row = 0; row < f.length; ++row) {
            for (int col = 0; col < f[row].length; ++col)
                System.out.print(f[row][col]+" ");
            System.out.println();
        }
    }
}
