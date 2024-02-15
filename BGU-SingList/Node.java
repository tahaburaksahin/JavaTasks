// BGU-SingList/Node.java
 
  // could be private static inner class of MyList
public class Node {
    int data;
    Node next;
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    Node(int data) {
        this(data,null);
    }
}
