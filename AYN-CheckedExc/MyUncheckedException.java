// AYN-CheckedExc/MyUncheckedException.java
 
public class MyUncheckedException
                    extends IllegalArgumentException {
    MyUncheckedException() {
        super();
    }
    MyUncheckedException(String message) {
        super(message);
    }
}
