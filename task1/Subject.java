package task1;

public class Subject {
    private Student[] studs;
    private Person teacher;
    private int freeIndex;
    private String name;

    public Subject(String name) {
        this.name = name;
        freeIndex = 0;
        studs = new Student[10];
    }

    public void setTeacher(Person p) {
        teacher = p;
    }

    public void addStudent(Student student) throws TooManyStudentsException {
        if (freeIndex == studs.length) {
            throw new TooManyStudentsException();
        } else {
            studs[freeIndex++] = student;
        }
    }

    public String toString() {
        String msg = name + ", teacher: " + teacher.getName() + ", students: ";
        for (int i = 0; i < freeIndex; i++) {
            msg += studs[i].getName() + " ";
        }
        return msg;
    }


}
