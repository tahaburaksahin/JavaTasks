// KFH-Close/Close.java
 
public class Close {
    public static void main(String... args) {
        try(Closeable cB = new Closeable("B");
            Closeable cA = new Closeable("A") )
        {
            cB.doSomething(1);
            cA.doSomething(1);
        } catch (Exception e) {
            System.out.println("In catch_1");
            e.printStackTrace();
            for(Throwable t : e.getSuppressed())
                System.out.println(t);
        }

        try(Closeable cX = new Closeable("X");
            Closeable cA = new Closeable("A") )
        {
            cA.doSomething(9);
            cX.doSomething(1);
        } catch (Exception e) {
            System.out.println("In catch_2");
            e.printStackTrace();
            for(Throwable t : e.getSuppressed())
                System.out.println(t);
        }

    }
}
