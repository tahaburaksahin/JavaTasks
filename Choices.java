// LSK-ChoiceFmt/Choices.java
 
import java.text.ChoiceFormat;
import java.util.Random;
import static java.lang.Math.min;
import static java.lang.Math.max;

public class Choices {
    public static void main(String[] args) {
        ChoiceFormat chform = new ChoiceFormat(
                new double[]{
                    Double.NEGATIVE_INFINITY,50,60,70,80,
                },
                new String[]{
                    "failing", "passing", "average",
                    "good",    "excellent",
                });

        Random rng = new Random(System.currentTimeMillis());

        for (int i = 0; i < 40; ++i) {
            double grade =
                max(0,min(15*rng.nextGaussian()+60,100));
            System.out.printf("%5.2f -> %s%n",grade,
                                chform.format(grade));
        }
    }
}
