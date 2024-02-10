// ELY-DefInterInherit/InterDef2.java
 
public interface InterDef2 {
    void abs2(); // public by default
    default String getName() {
        return "Def2";
    }
    default void specific2() {
        System.out.print("Specific2");
    }
}
