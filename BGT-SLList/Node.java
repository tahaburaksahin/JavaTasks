// BGT-SLList/Node.java
 
public class Node {
    private String   data;
    private Node next;
    public Node(String d, Node list) {
        data = d;
        next = list;
    }
    public Node(String d) {
        this(d,null);
    }
    public String getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node n) {
        next = n;
    }
}
