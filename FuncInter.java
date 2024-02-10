// ELX-FuncInter/FuncInter.java
 
@FunctionalInterface
interface MyInterface<T> {
    int len(T t);
}

public class FuncInter {
    static <T> int calc(T arg, MyInterface<T> f) {
        return f.len(arg);
    }

    public static void main (String[] args) {
        String s = "Alice";
        int result1 = calc(
            s,
            new MyInterface<String>() {
                @Override
                public int len(String s) {
                    return s.length();
                }
            });
        System.out.println("result1 = " + result1);

        Double d = 123.456; // boxing
        int result2 =
            calc(d, v -> v.toString().length());
        System.out.println("result2 = " + result2);

        int result3 =
            calc(d, v -> (int)(1000*v+4));
        System.out.println("result3 = " + result3);
    }
}
