// BGW-Stack/MyStack.java
 
public class MyStack {
    private Node head = null;
    public void push(int data) {
        head = new Node(data,head);
    }
    public int pop() {
        int d = head.getData();
        head = head.getNext();
        return d;
    }
    public boolean empty() {
        return head == null;
    }
}
