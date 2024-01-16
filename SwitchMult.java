// ACF-SwitchMult/SwitchMult.java
// Taha Burak Sahin PJATK

public class SwitchMult {
    public static void main(String[] args) {
        String n = "BMW", country = null;
        switch (n) {
            case "BMW", "Opel", "Audi" -> country = "Germany";
            case "Peugeot", "Citroen"  -> country = "France";
            default                    -> country = "unknown";
        }
        System.out.println(n + " -> " + country);
    }
}
