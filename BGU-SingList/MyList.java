// BGU-SingList/MyList.java
 
public class MyList {
    private Node head;

    public MyList() {
        head = null;
    }

    public void addFront(int data) {
        head = new Node(data,head);
    }

    public void addBack(int data) {
        if (head == null) {
            addFront(data);
            return;
        }
        Node tmp = head;
        while(tmp.next != null)
            tmp = tmp.next;
        tmp.next = new Node(data);
    }
    public void showList() {
        System.out.print("[ ");
        Node tmp = head;
        while(tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println("]");
    }
    public void showListReversed() {
        System.out.print("[ ");
        showRev(head);
        System.out.print("]");
    }
    private void showRev(Node h) {
        if (h.next != null) showRev(h.next);
        System.out.print(h.data + " ");
    }
    public int size() {
          // inefficient!
        int count = 0;
        Node tmp = head;
        while(tmp != null) {
            ++count;
            tmp = tmp.next;
        }
        return count;
    }
    public boolean empty() {
        return head == null;
    }
}
