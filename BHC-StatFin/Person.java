// BHC-StatFin/Person.java
 
public class Person {
    protected String name;
    protected int    year;
    protected Person mother;
    protected Person father;
    private final int idNum;
    public static int ID;

    public Person(String n, int y, Person m, Person f) {
        name = n;
        year = y;
        mother = m;
        father = f;
        idNum = ++ID;
    }
    public Person(String n, int y, Person m) {
        this(n,y,m,null);
    }
    public Person(String n, int y) {
        this(n,y,null,null);
    }
    public int    getYear() { return year; }
    public String getName() { return name; }

    @Override
    public String toString() {
        String m = mother != null ? mother.name : "Unknown";
        String f = father != null ? father.name : "Unknown";
        return name + " (ID" +idNum + ", " + year + ", " +
                                         m + ", " + f + ")";
    }
    public static Person getOldest(Person[] people) {
        Person oldest = people[0];
        for (Person p : people)
            if (p.year < oldest.year) oldest = p;
        return oldest;
    }

    public void showSwordSide() {
        System.out.println(name + "'s sword side");
        Person p = father;
        while(p != null) {
            System.out.println("    " + p);
            p = p.father;
        }
        System.out.println();
    }
    public void showDistaffSide() {
        System.out.println(name + "'s distaff side");
        Person p = mother;
        while(p != null) {
            System.out.println("    " + p);
            p = p.mother;
        }
        System.out.println();
    }
}
