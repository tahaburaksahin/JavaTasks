// GXR-RegExNames/Name.java
 
import java.util.ArrayList;

public class Name {
    private String name;
    private ArrayList<Integer> list;
    private int total = 0;

    public Name(String name, int lineNo) {
        this.name = name;
        list = new ArrayList<Integer>();
        list.add(lineNo);
        total = 1;
    }

    public void addNum(int lineNo) {
        if (list.get(list.size()-1) != lineNo)
            list.add(lineNo);
        ++total;
    }

    @Override
    public String toString() {
        return name + " (" + total + ") in lines " + list;
    }
}
