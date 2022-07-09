import java.lang.Math;

public class Matematica {
    public static double pi(int n) {
        double sum = 0.0;
        for (int i=1; i<=n; i++) {
            sum += (-Math.pow(-1, i)) * (1.0/(2*i - 1));
        }
        return 4.0*sum;
    }
}