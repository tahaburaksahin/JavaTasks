// BGI-VerySimple/VerySimple.java
 
public class VerySimple {
    private int    age;
    private String name;

      // constructor
    public VerySimple(int age, String n) {
        this.age = age;
        name = n;
    }
      //getter
    public int getAge()  {
        return age;
    }
      // setter
    void setAge(int a) { // package private
        age = a;
    }
      // getter (with no corresponding setter)
    public String getName() {
        return name;
    }
}
