package task7;

import task6.Person;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Person smith = new Person("Oliver", "Smith");
        Person jones = new Person("Jack", "Jones");
        Person harry = new Person("Harry", "Williams");
        Person jacob = new Person("Jacob", "Brown");

        Car skoda1 = new Car("WA00001", Car.Brand.SKODA);
        Car skoda2 = new Car("SC36010", Car.Brand.SKODA);
        Car mazda1 = new Car("WA01234", Car.Brand.MAZDA);
        Car mazda2 = new Car("DW01ASD", Car.Brand.MAZDA);
        Car bmw = new Car("WA12690", Car.Brand.BMW);
        Car volvo = new Car("KR60606", Car.Brand.VOLVO);

        /*
         * Oliver Smith -> SKODA WA00001, BMW WA12690
         * Jack Jones -> MAZDA DW01ASD
         * Harry Williams -> VOLVO KR60606, MAZDA WA01234, SKODA SC36010
         * Jacob Brown -> [No cars]
         *
         * Cars whose registration numbers begin with WA:
         * SKODA WA00001
         * BMW WA12690
         * MAZDA WA01234
         * */

        Map<Person, List<Car>> carMap = new LinkedHashMap<>();
        carMap.put(smith, new LinkedList<>());
        carMap.put(jones, new LinkedList<>());
        carMap.put(harry, new LinkedList<>());
        carMap.put(jacob, new LinkedList<>());

        carMap.get(smith).add(skoda1);
        carMap.get(smith).add(bmw);

        carMap.get(jones).add(mazda1);

        carMap.get(harry).add(volvo);
        carMap.get(harry).add(mazda2);
        carMap.get(harry).add(skoda2);

        for (Map.Entry<Person, List<Car>> entry : carMap.entrySet()) {
            if (entry.getValue().size() == 0)
                System.out.println(entry.getKey() + " -> [No cars]");
            else
                System.out.println(entry.getKey() + " -> " + entry.getValue().toString().replaceAll("[\\[\\]]", ""));
        }


        System.out.println("Cars whose registration numbers begin with WA:");

        for (List<Car> cars: carMap.values()) {
            for (Car car : cars)
                if (car.getRegistrationNumber().startsWith("WA"))
                    System.out.println(car);
        }

        for (Map.Entry<Person, List<Car>> entry : carMap.entrySet()) {
            if (entry.getValue().size() == 0)
                System.out.println();
            System.out.println(entry.getKey() + " owns " + entry.getValue().size() + " cars");
            // eg: Oliver Smith owns 2 cars
        }

        System.out.println(carMap.get(jones).get(0));
        // MAZDA DW01ASD
    }

}
