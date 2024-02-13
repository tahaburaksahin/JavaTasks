// BHI-StrBuilder/StrBuilder.java
 
public class StrBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("three");
        sb.append(",four")
          .insert(0,"twoxx,")
          .insert(0,"one,")
          .delete(sb.indexOf("x"), sb.indexOf("x")+2);
        System.out.println("sb = " + sb.toString());

        final int NUMB = 50_000;
        long startTime;

        startTime = System.nanoTime();
        String s = "0";
        for (int i = 1; i <= NUMB; ++i)
            s = s + i;
        long elapsedS = System.nanoTime() - startTime;
        System.out.printf(" String: %10d ns = %.3f sec%n",
                                 elapsedS, elapsedS*1e-9);

        startTime = System.nanoTime();
        StringBuilder builder = new StringBuilder("0");
        for (int i = 0; i <= NUMB; ++i)
            builder.append(i);
        long elapsedB = System.nanoTime() - startTime;
        System.out.printf("Builder: %10d ns = %.3f sec%n",
                                 elapsedB, elapsedB*1e-9);

        System.out.printf("elapsedS/elapsedB = %.2f%n",
                           (double)elapsedS/elapsedB);
    }
}
