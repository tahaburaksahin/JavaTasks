// BHG-StatOrd/Stats.java
 
public class Stats {
    private static int sino;
    private static int siyes = 2;
    private static final int fin;

    {          // nonstatic initialization block
        show("nonstatic init");
        sino = 1;
    }

    static {   // static initialization block
        show("   static init");
        fin = 3;
    }

    public Stats() {
        show("   constructor");
    }

    private static void show(String mes) {
        System.out.println(mes + ":" +
                " sino=" + sino +
                " siyes=" + siyes +
                " fin=" + fin);
    }
}
