package task1;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void sayHelloTo(Person p) {
        System.out.println("Hi " + p.name + "!");
    }

}
