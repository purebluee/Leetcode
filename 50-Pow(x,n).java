
public class Solution {
    public double myPow(double x, int n) {
        if (n < 0){
            n = -n;
            x = 1 / x;
        }
        double res = 1;
        for (double f = x; n > 0; n /= 2){
            if (n % 2 == 1){
                res *= f;
            }
            f = f * f;
        }
        return res;
    }
}