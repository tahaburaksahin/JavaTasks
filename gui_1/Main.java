import java.util.HashSet;
import java.util.Set;

class TooManyStudentsException extends Exception {
    // Exception class for handling too many students
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void sayHelloTo(Person person) {
        System.out.println("Hi " + person.name + "!");
    }
}

class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }
}

class Subject {
    String name;
    Person teacher;
    Set<Student> students;

    public Subject(String name) {
        this.name = name;
        this.students = new HashSet<>();
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student) throws TooManyStudentsException {
        if (students.size() >= 10) {
            throw new TooManyStudentsException();
        }
        students.add(student);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(name + ", teacher: " + teacher.name + ", students: ");
        for (Student student : students) {
            result.append(student.name).append(", ");
        }
        if (!students.isEmpty()) {
            result.delete(result.length() - 2, result.length()); // Remove the last comma and space
        }
        return result.toString();
    }
}

public class Main {
    public static void main(String args[]) {
        Person p1 = new Person("Taha ", 50);
        Student s1 = new Student("Burak", 20);
        Person p3 = (Person) s1;
        p1.sayHelloTo(p3); // Hi Jasiek!
        p3.sayHelloTo(p1); // Hi Jan!

        Subject s = new Subject("GUI");
        s.setTeacher(p1);
        try {
            s.addStudent(s1);
        } catch (TooManyStudentsException e) {
            e.printStackTrace();
        }
        System.out.println(s); // GUI, teacher: Jan, students: Jasiek
    }
}
