package task2;

public class PersonalComputer extends Computer{
    private String username;

    public PersonalComputer(String typeOfChip, double memorySize, String username){
        super(typeOfChip, memorySize);
        this.username = username;
    }

    public String toString(){
        return super.toString() + ", username: " + username;
    }
}
