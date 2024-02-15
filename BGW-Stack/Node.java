// BGW-Stack/Node.java
 
  // could be private static inner class of MyStack
public class Node {
    private int data;
    private Node next;
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    Node(int data) {
        this(data,null);
    }
    int  getData() { return data; }
    Node getNext() { return next; }
}
