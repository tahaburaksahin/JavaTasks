// ELY-DefInterInherit/InterDef1.java
 
public interface InterDef1 {
      // all methods public by default
    void abs1();
    default String getName() {
        return "Def1";
    }
    default void specific1() {
        System.out.println("Specific1");
    }
}
