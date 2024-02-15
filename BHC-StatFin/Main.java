// BHC-StatFin/Main.java
 
public class Main {
    public static void main(String[] args) {
        Person john = new Person("John",1915);
        Person mary = new Person("Mary",1919);
        Person bill = new Person("Bill",1917);
        Person jane = new Person("Jane",1920);
        Person charles = new Person("Charles",1917);
        Person kate = new Person("Kate",1921);
        Person kevin = new Person("Kevin",1920);
        Person suzy = new Person("Suzy",1917);

        Person[] arr = {   john, mary,  bill, jane,
                        charles, kate, kevin, suzy };
        System.out.println("Oldest: " +
                            Person.getOldest(arr) + "\n");

        Person alice = new Person("Alice",1943,mary,john);
        Person willy = new Person("Willy",1940,jane,bill);
        Person   sue = new Person("Sue",1946,kate,charles);
        Person   rod = new Person("Rod",1939,suzy,kevin);

        Person james = new Person("James",1963,alice,willy);
        Person  ella = new Person("Ella",1966,sue,rod);

        Person  don = new Person("Don",1990,ella,james);
        don.showDistaffSide();
        don.showSwordSide();

        System.out.println("Number of objects created: " +
                                                Person.ID);
    }
}
