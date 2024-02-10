// ELW-LambdaInter/MyBiOp.java
 
import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface MyBiOpInterface<T> {
    T apply(T a, T b);
}

class Mult implements MyBiOpInterface<Double> {
    @Override
    public Double apply(Double a, Double b) { return a*b; }
}

public class MyBiOp {
    public static void main (String[] args) {
        List<MyBiOpInterface<Double>>
                    opers = new ArrayList<>();

          // addition - reference to (static) method
        opers.add( Double::sum );

          // subtraction - anonymous class
        opers.add( new MyBiOpInterface<Double>() {
            @Override
            public Double apply(Double a, Double b) {
                return a - b;
            }
        });

          // multiplication - object of a named class
          // implementing the MyBiOpInterface interface
        opers.add( new Mult() );

          // division - lambda
        opers.add( (a,b) -> a/b );

          // with closure ('shift' is effectively final)
        int shift = 10;
        opers.add( (a,b) -> a/b + shift);

        for (MyBiOpInterface<Double> op : opers)
            System.out.println(op.apply(10.5,3.5));
    }
}
