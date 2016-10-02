public class Solution {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        while (n % 2 ==0){
            if (n > 2)  n /= 2;
            else return true;
        }
        return (n % 2 == 0);
    }
}