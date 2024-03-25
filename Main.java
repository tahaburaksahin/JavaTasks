public class Main {

    public static void main(String[] args) {

        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++)
            arr[i] = (int)(Math.random()*100) + 1;

        print(arr, val -> val % 2 == 0);

    }

    public static void print(int[] arr, Filtrator filtrator){
        for (int i : arr)
            if (filtrator.filter(i))
                System.out.println(i);
    }

}