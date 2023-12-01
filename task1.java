// Taha Burak Sahin PJATK


public class task1 {

    public static void selSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void sortRows(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            selSort(arr[i]);
        }
    }

    public static void sortCols(int[][] arr) {
        int maxRowLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length > maxRowLength) {
                maxRowLength = arr[i].length;
            }
        }

        for (int col = 0; col < maxRowLength; col++) {
            for (int row = 0; row < arr.length; row++) {
                if (col < arr[row].length) {
                    for (int k = row + 1; k < arr.length; k++) {
                        if (col < arr[k].length && arr[k][col] < arr[row][col]) {
                            int temp = arr[row][col];
                            arr[row][col] = arr[k][col];
                            arr[k][col] = temp;
                        }
                    }
                }
            }
        }
    }

    public static void printArr2D(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j < arr[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        int[][] a = { {3,2,6,1,3,5,6,1,3},
                {3,1,2,1,5,7,2},
                {8,9,2,1} };
        System.out.println("Before:");
        printArr2D(a);
        sortRows(a);
        System.out.println("After:");
        printArr2D(a);

        int[][] b = { {3,2,6,1,6},
                {7,1,2,1,5},
                {5,3,1,8,7},
                {8,9,2,7,1} };
        System.out.println("Now columns\nBefore:");
        printArr2D(b);
        sortCols(b);
        System.out.println("After:");
        printArr2D(b);
    }
}