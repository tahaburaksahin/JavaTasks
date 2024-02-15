// BGT-SLList/Main.java
 
public class Main {
    public static void main (String[] args) {
          // constructing a singly linked list
        Node fourth = new Node("Dora");
        Node third  = new Node("Cindy",fourth);
        Node secnd  = new Node("Bea",third);
        Node head   = new Node("Alice");
        head.setNext(secnd);

          // printing...
        System.out.println("head   " + head
                                      .getData());
        System.out.println("secnd  " + head
                                      .getNext()
                                      .getData());
        System.out.println("third  " + head
                                      .getNext()
                                      .getNext()
                                      .getData());
        System.out.println("fourth " + head
                                      .getNext()
                                      .getNext()
                                      .getNext()
                                      .getData());
        System.out.println("NONE   " + head
                                      .getNext()
                                      .getNext()
                                      .getNext()
                                      .getNext() + "\n");
          // printing in a loop...
        Node list = head;
        while (list != null) {
            System.out.print(list.getData() + " ");
            list = list.getNext();
        }
        System.out.println();
    }
}
