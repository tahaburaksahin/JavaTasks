package task3;

public class Main {
    public static void main(String[] args) {
        Color violet = Color.mixColors(Color.RED, Color.BLUE);
        Color orange = Color.mixColors(Color.RED, Color.YELLOW);
        Color green = Color.mixColors(Color.YELLOW, Color.BLUE);

        System.out.println(violet + " " + orange + " " + green);
    }
}