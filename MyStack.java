// GMC-StackSimple/MyStack.java
 
public class MyStack {
      // static inner class
    private static class Node {
        int  data;
        Node next;
        Node(int d, Node n) {
            data = d;
            next = n;
        }
    }

    private Node top;

    public MyStack() {
        top = null;
    }
    public void push(int d) {
        top = new Node(d, top);
    }
    public int pop() {
        int d = top.data;
        top = top.next;
        return d;
    }
    public boolean empty() {
        return top == null;
    }
}
