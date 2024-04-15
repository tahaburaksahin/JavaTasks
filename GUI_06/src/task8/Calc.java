package task8;

import java.util.HashMap;
import java.util.Map;

public class Calc {

    private Map<String, Operation> map;

    public Calc(){
        map = new HashMap<String, Operation>();
        map.put("+", (num1, num2) -> num1 + num2);
        map.put("-", (num1, num2) -> num1 - num2);
        map.put("*", (num1, num2) -> num1 * num2);
        map.put("/", (num1, num2) -> num1 / num2);
    }

    public String doCalc(String operation) {
        String[] arr = operation.split(" ");
        Operation op = map.get(arr[1]);
        double res = op.execute(Double.parseDouble(arr[0]), Double.parseDouble(arr[2]));
        return String.valueOf(res);
    }

}
