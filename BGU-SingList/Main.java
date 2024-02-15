// BGU-SingList/Main.java
 
public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.addBack(4);
        list.addBack(5);
        list.addFront(3);
        list.addFront(2);
        list.addFront(1);
        list.showList();
        list.showListReversed();
        System.out.println("\nsize = " + list.size());
    }
}
