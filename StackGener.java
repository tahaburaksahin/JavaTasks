// GMD-StackGener/StackGener.java
 
public class StackGener {

    public static class MyStack<E> {
        private static class Node<T> {
            T    data;
            Node<T> next;
            Node(T d, Node<T> n) {
                data = d;
                next = n;
            }
        }
        private Node<E> top;

        public MyStack() {
            top = null;
        }
        public void push(E d) {
            top = new Node<E>(d, top);
        }
        public E pop() {
            E d = top.data;
            top = top.next;
            return d;
        }
        public boolean empty() {
            return top == null;
        }
    }

    public static void main (String[] args) {
        MyStack<String> stString = new MyStack<>();
        MyStack<Double> stDouble = new MyStack<>();
        for (int i = 5; i > 0; --i) {
            stString.push(String.valueOf(i));
            stDouble.push(Double.valueOf(i));
        }
        while (!stString.empty())
            System.out.println(
                    "String: " + stString.pop() + "  " +
                    "Double: " + stDouble.pop());
    }
}
