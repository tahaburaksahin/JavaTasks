// BGY-SimpQueue/MyQueue.java
 
public class MyQueue {
      // nested class
    private static class Node {
        String data;
        Node next = null;
        Node(String d) { data = d; }
    }

    private Node head, tail;

    public MyQueue() {
        head = tail = null;
    }
    public void enqueue(String s) {
        if (head == null)
            head = tail = new Node(s);
        else
            tail = tail.next = new Node(s);
    }
    public String dequeue() {
        String s = head.data;
        if ((head = head.next) == null) tail = null;
        return s;
    }
    public boolean empty() {
        return head == null;
    }
}
