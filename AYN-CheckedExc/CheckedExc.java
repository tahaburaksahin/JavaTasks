// AYN-CheckedExc/CheckedExc.java
 
public class CheckedExc {

    public static void main(String[] args) {

        try {
            goSleep(3*1000);
        } catch(InterruptedException ignored) {
            System.err.println("Interrupted");
        } finally {
            System.err.println("AFTER SLEEP");
        }

          // handling all exceptions
        try {
            goSleep(-1);
        } catch(InterruptedException e) {
            System.err.println("Interrupted");
        } catch(Exception e) {
            System.err.println("Handling exception: " +
                                       e.getMessage());
        } finally {
            System.err.println("GOING ON");
        }

          // here MyUncheckedException is  n o t  handled
          // so the program  w i l l  crash (but 'finally'
          // clause will be executed anyway)
        try {
            goSleep(-1);
        } catch(InterruptedException e) {
            System.err.println("Interrupted");
        } finally {
            System.err.println("QUITTING");
        }
    }

    private static void goSleep(int time)
                            throws InterruptedException {
        if (time < 0)
            throw new MyUncheckedException("Negative time");

        System.out.println(
                "Going to sleep for " + time +"ms");
        Thread.sleep(time);
        System.out.println("Waking up");
    }
}
