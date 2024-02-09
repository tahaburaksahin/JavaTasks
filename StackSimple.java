// GMC-StackSimple/StackSimple.java
 
public class StackSimple {
    public static void main (String[] args) {
        MyStack stInt = new MyStack();
        for (int i = 5; i > 0; --i)
            stInt.push(i);
        while (!stInt.empty())
            System.out.print(stInt.pop() + " ");
        System.out.println();
    }
}
