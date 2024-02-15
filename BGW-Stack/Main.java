// BGW-Stack/Main.java
 
public class Main {
    public static void main(String[] args) {
        MyStack st = new MyStack();
        st.push(4);
        st.push(5);
        st.push(6);
        while (!st.empty())
            System.out.println("popping " + st.pop());
    }
}
