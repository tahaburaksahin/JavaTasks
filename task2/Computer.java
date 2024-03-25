package task2;

public class Computer {
    private int id;
    private static int counter = 0;
    private String typeOfChip;
    private double memorySize;

    public Computer(String typeOfChip, double memorySize){
        this.typeOfChip = typeOfChip;
        this.memorySize = memorySize;
        id = ++counter;
    }

    public String toString(){
        return "ID: " + id  + ", type of chip: " + typeOfChip + ", memory size: " + memorySize +"GB";
    }

}
