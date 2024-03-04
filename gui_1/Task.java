class Computer {
    private static int nextId = 1;

    protected int id;
    protected String chipType;
    protected double memorySize;

    public Computer(String chipType, double memorySize) {
        this.id = nextId++;
        this.chipType = chipType;
        this.memorySize = memorySize;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", type of chip: " + chipType + ", memory size: " + memorySize + " GB";
    }
}

class Laptop extends Computer {
    private String username;
    private double weight;

    public Laptop(String chipType, double memorySize, String username, double weight) {
        super(chipType, memorySize);
        this.username = username;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + ", username: " + username + ", weight: " + weight + " g";
    }

    public void checkWeight() throws Exception {
        if (weight > 5000) {
            throw new Exception("This laptop is not ergonomic - too heavy, over 5000 g!");
        }
    }
}

class PersonalComputer extends Computer {
    private String username;

    public PersonalComputer(String chipType, double memorySize, String username) {
        super(chipType, memorySize);
        this.username = username;
    }

    @Override
    public String toString() {
        return super.toString() + ", username: " + username;
    }
}

public class Task {
    public static void main(String[] args) {
        Laptop laptop = new Laptop("AMD", 64, "PPJ", 12345);
        Computer[] computers = new Computer[]{new Computer("i7", 24), laptop, new PersonalComputer("i5", 10.5, "PJA")};

        for (int i = 0; i < computers.length; i++) {
            System.out.println(computers[i]);
        }

        try {
            laptop.checkWeight();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
