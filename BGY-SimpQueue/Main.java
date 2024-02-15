// BGY-SimpQueue/Main.java
 
public class Main {
    public static void main (String[] args) {
        MyQueue qS = new MyQueue();
        for (double d = 0.5; d < 5; d += 1)
            qS.enqueue("" + d);
        while (!qS.empty())
            System.out.print(qS.dequeue() + " ");
        System.out.println();
    }
}
