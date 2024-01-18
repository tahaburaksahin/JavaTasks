// AFE-DoWhileDice/Dice.java
// taha burak sahin pjatk

public class Dice {
    public static void main (String[] args) {
        int a, b;
        do {
            a = 1 + (int)(Math.random()*6);
            b = 1 + (int)(Math.random()*6);
            System.out.println("a=" + a + " b=" + b);
        } while (a + b != 12);
    }
}
