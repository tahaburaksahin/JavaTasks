// BGR-BasicClass/Main.java
 
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        Person john = new Person("John", 1980);
        Person mary = new Person("Mary", 1985);

        System.out.println(
            "Two Persons created: " +john + " and " + mary);

        Person older = mary.isOlderThan(john) ? mary : john;
        System.out.println("Older: " + older.getName() +
                " born in " + older.getYear());

        String s = older + " is older";

        // JOptionPane.showMessageDialog(null,s);
        System.out.println(s);
        System.exit(0);
    }
}
