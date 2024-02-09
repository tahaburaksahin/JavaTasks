// FUI-AnnoProc/AnnoTest.java
 
package myapplication;

public class AnnoTest {
    public static void main(String[] args) {
        Person jan = new Person();
        jan.setName("Jasio");
        jan.setYear(1980);
        Car merc = new Car();
        merc.setMake("Mercedes");
        merc.setSpeed(210);
        System.out.println(jan.getName() + "(" +
                jan.getYear() + ") has " + merc.getMake() +
                "(" + merc.getSpeed() + ")");
    }
}
