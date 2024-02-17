// BGI-VerySimple/Main.java
 
public class Main {
    public static void main(String[] args) {
        VerySimple alice = new VerySimple(23,"Alice");
        VerySimple bob   = new VerySimple(21,"Bob");
        alice.setAge(18);

        System.out.println(
                alice.getName()  + " " + alice.getAge());
        System.out.println(
                bob.getName()    + " " + bob.getAge());
    }
}
