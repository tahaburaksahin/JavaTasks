// KFH-Close/Closeable.java
 

public class Closeable implements AutoCloseable {
    Object resource;

    Closeable(Object resource) {
        this.resource = resource;
        // acquire resource, whatever it means...
        System.out.println("Resource acquired");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing " + resource);
        if (((String)resource).startsWith("X"))
            throw new RuntimeException(
                    "Exception from close");
    }

    public void doSomething(int n) {
        System.out.println("In 'doSomething': "+resource);
        if (n > 5)
            throw new UnsupportedOperationException(
                    "Exception in doSomething");
    }
}
