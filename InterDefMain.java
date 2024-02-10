// ELY-DefInterInherit/InterDefMain.java
 
public class InterDefMain
             implements InterDef1, InterDef2 {

      // those were abstract; implementation required
    @Override
    public void abs1() {
        System.out.println("abs1");
    }
    @Override
    public void abs2() {
        System.out.println("abs2");
    }

      // overriding necessary, as two versions inherited
    @Override
    public String getName() {
        return "From 1: " + InterDef1.super.getName() +
             "\nFrom 2: " + InterDef2.super.getName();
    }

      // we may override but we don't have to...
    @Override
    public void specific2() {
        InterDef2.super.specific2();
        System.out.println(" corrected");
    }

    public static void main (String[] args) {
        InterDefMain m = new InterDefMain();
        m.abs1();
        m.abs2();
        System.out.println(m.getName());

        m.specific1();
        m.specific2();
    }
}
