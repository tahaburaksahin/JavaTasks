// GME-QueueGener/QueueGener.java
 
public class QueueGener {
    public static void main (String[] args) {
        MyQueue<String> queueS = new MyQueue<>();
        MyQueue<Double> queueD = new MyQueue<>();
        for (double d = 0.5; d < 5; d += 1) {
            queueS.enqueue(String.valueOf(d));
            queueD.enqueue(d); // boxing
        }
        while (!queueS.empty() && !queueD.empty()) {
              // no casting required
            String s = queueS.dequeue();
            double d = queueD.dequeue();
            System.out.println(
                    "String: " + s +  "  " +
                    "Double: " + d);
        }
    }
}
