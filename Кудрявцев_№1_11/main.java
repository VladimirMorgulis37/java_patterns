import java.lang.Math;

public class main implements Predicate {
    @Override
    public boolean test(double x) {
        if (x >= 1) {
            int i = -1;
            while (true) {
                i++;
                if (x > Math.pow(2, i))
                    continue;
                return (x == Math.pow(2, i));
            }
        }
        else if (x > 0 && x < 1) {
            int i = 0;
            while (true)    {
                i--;
                if (x < Math.pow(2,i))
                    continue;
                return (x == Math.pow(2,i));
            }
        }
        else
            return false;
    }
    public static void main(String[] args) {
        main example = new main();
        System.out.println(example.test(1));
        System.out.println(example.test(4));
        System.out.println(example.test(5));
        System.out.println(example.test(0.26));
        System.out.println(example.test(0.25));
    }
}
