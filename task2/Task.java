package task2;

public class Task {
    public static void main(String[] args) {
        Laptop laptop = new Laptop(" AMD ", 64, " PPJ ", 12345);
        Computer[] computers = new Computer[]{new Computer("i7", 24), laptop, new
                PersonalComputer("i5", 10.5, " PJA ")};

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
