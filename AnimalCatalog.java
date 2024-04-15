// Write a program which will let the user catalog different kinds of animals based on their traits. It
//        is known that all animals have their weight and a known amount of legs. Fish vary in the amount of fins
//        and they can swim. Cats can have different kinds of fur patters and they walk. Ducks vary in the bill
//        shape and can walk, fly and swim. Animals are naturally ordered by their weight.
//        Based on the description and good programming practises create accurate classes and interfaces including
//        their hierarchy. Then, in the main method create an array of all mentioned animals and sort it. Then
//        create another three arrays that will hold animals that can: walk, fly and swim

import java.util.*;

// Interface for animals that can move
interface Movable {
    void move();
}

// Interface for animals that can swim
interface Swimmable {
    void swim();
}

// Interface for animals that can fly
interface Flyable {
    void fly();
}

// Animal class with weight and number of legs properties
abstract class Animal implements Comparable<Animal> {
    protected double weight;
    protected int legs;

    public Animal(double weight, int legs) {
        this.weight = weight;
        this.legs = legs;
    }

    @Override
    public int compareTo(Animal other) {
        return Double.compare(this.weight, other.weight);
    }
}

// Fish class
class Fish extends Animal implements Swimmable {
    private int fins;

    public Fish(double weight, int legs, int fins) {
        super(weight, legs);
        this.fins = fins;
    }

    @Override
    public void swim() {
        System.out.println("The fish is swimming.");
    }
}

// Cat class
class Cat extends Animal implements Movable {
    private String furPattern;

    public Cat(double weight, int legs, String furPattern) {
        super(weight, legs);
        this.furPattern = furPattern;
    }

    @Override
    public void move() {
        System.out.println("The cat is walking.");
    }
}

// Duck class
class Duck extends Animal implements Movable, Flyable, Swimmable {
    private String billShape;

    public Duck(double weight, int legs, String billShape) {
        super(weight, legs);
        this.billShape = billShape;
    }

    @Override
    public void move() {
        System.out.println("The duck is walking.");
    }

    @Override
    public void fly() {
        System.out.println("The duck is flying.");
    }

    @Override
    public void swim() {
        System.out.println("The duck is swimming.");
    }
}

public class AnimalCatalog {
    public static void main(String[] args) {
        // Create an array of animals
        Animal[] animals = {
                new Fish(0.5, 0, 2),
                new Cat(4.5, 4, "Tabby"),
                new Duck(2.0, 2, "Wide"),
                new Fish(0.3, 0, 1),
                new Duck(1.5, 2, "Narrow"),
                new Cat(3.2, 4, "Calico")
        };

        // Sort the array of animals by weight
        Arrays.sort(animals);

        // Create arrays to hold animals that can walk, fly, and swim
        List<Movable> walkingAnimals = new ArrayList<>();
        List<Flyable> flyingAnimals = new ArrayList<>();
        List<Swimmable> swimmingAnimals = new ArrayList<>();

        // Populate the arrays based on the type of animal
        for (Animal animal : animals) {
            if (animal instanceof Movable) {
                walkingAnimals.add((Movable) animal);
            }
            if (animal instanceof Flyable) {
                flyingAnimals.add((Flyable) animal);
            }
            if (animal instanceof Swimmable) {
                swimmingAnimals.add((Swimmable) animal);
            }
        }

        // Print the sorted array of animals
        System.out.println("Sorted animals:");
        for (Animal animal : animals) {
            System.out.println("Weight: " + animal.weight + ", Legs: " + animal.legs);
        }

        // Print animals that can walk
        System.out.println("\nAnimals that can walk:");
        for (Movable animal : walkingAnimals) {
            animal.move();
        }

        // Print animals that can fly
        System.out.println("\nAnimals that can fly:");
        for (Flyable animal : flyingAnimals) {
            animal.fly();
        }

        // Print animals that can swim
        System.out.println("\nAnimals that can swim:");
        for (Swimmable animal : swimmingAnimals) {
            animal.swim();
        }
    }
}
