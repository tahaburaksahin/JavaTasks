package task1;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Jan", 50);
        Student s1 = new Student("Jasiek", 20);
        Person p3 = (Person) s1;
        p1.sayHelloTo(p3);
        p1.sayHelloTo(p1);

        Subject s = new Subject("Gui");
        s.setTeacher(p1);

        try {
            s.addStudent(s1);
        } catch (TooManyStudentsException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}