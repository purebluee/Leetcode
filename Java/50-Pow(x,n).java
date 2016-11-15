
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

    //slow answer:
    public double myPowSlow(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        int sign = 1;
        if (n < 0){
            sign = -1;
            n = -n;
        }
        double res = x;
        
        while (n > 1){
            res = res * x;
            n--;
        }

        return sign > 0 ? res : 1/res;
    }
}