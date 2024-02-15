// BGX-Singlet/Main.java
 
public class Main {
    public static void main(String[] args) {
        Connect con1 = Connect.getInstance();
        Connect con2 = Connect.getInstance();
        if (con1 == con2) System.out.println("con1==con2");
        Config cnf1 = Config.getInstance();
        Config cnf2 = Config.getInstance();
        if (cnf1 == cnf2) System.out.println("cnf1==cnf2");
    }
}
