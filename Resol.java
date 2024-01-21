// AFN-Resol/Resol.java
//taha burak sahin pjatk 

public class Resol {
    static void f(short a)  {System.out.println("s=" + a);}
    static void f(int a)    {System.out.println("i=" + a);}
    static void f(double a) {System.out.println("d=" + a);}

    public static void main (String[] args) {
        byte   ab =  65;
        char   ac = 'A';
        short  as =  65;
        int    ai =  65;
        long   al = 65L;
        double ad = 65D;
        System.out.print("byte   -> "); f(ab);
        System.out.print("char   -> "); f(ac);
        System.out.print("short  -> "); f(as);
        System.out.print("int    -> "); f(ai);
        System.out.print("long   -> "); f(al);
        System.out.print("double -> "); f(ad);
    }
}
