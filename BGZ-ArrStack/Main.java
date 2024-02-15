// BGZ-ArrStack/Main.java
 
public class Main {
    public static void main (String[] args) {
        ArrStack stack = new ArrStack(5);
        for (int i = 1; i <= 5; ++i)
            stack.push(i*i);
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
        System.out.println();
    }
}
