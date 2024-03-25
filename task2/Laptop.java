package task2;

public class Laptop extends PersonalComputer{
    private double weight;

    public Laptop(String typeOfChip, double memorySize, String username, double weight){
        super(typeOfChip,memorySize,username);
        this.weight = weight;
    }

    public String toString(){
        return super.toString() + ", weight: " + weight + "g";
    }
    public void checkWeight() throws Exception{
        if(weight > 5000){
            throw new Exception("This laptop is not ergonomic - too heavy, over 5000g!");
        }else
            System.out.println("This laptop is ergonomic");
    }
}
