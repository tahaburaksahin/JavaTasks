// BGX-Singlet/Connect.java
 
public class Connect {

    private static Connect connection = null;

    private Connect()
    { } // private - no one can create any other object

    public static Connect getInstance() {
          // lazy evaluation, no multithreading
        if(connection == null){
            connection = new Connect();
        }
        return connection;
    }
}
