package task7;

public class Car {

    public static enum Brand {SKODA, MAZDA, BMW, VOLVO};

    private String registrationNumber;
    private Brand brand;

    public Car(String registrationNumber, Brand brand){
        this.registrationNumber = registrationNumber;
        this.brand = brand;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String toString() {
        return brand + " " + registrationNumber;
    }
}
