// BGZ-ArrStack/ArrStack.java
 
public class ArrStack {
    private int[] elems;
    private int top = 0;
    public ArrStack(int maxSize) {
        elems = new int[maxSize];
    }
    public void push(int e) {
          // throws if stack full
        elems[top++] = e;
    }
    public int pop() {
          // throws if stack empty
        return elems[--top];
    }
    public boolean empty() {
        return top == 0;
    }
}

