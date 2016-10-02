public class Solution {
    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
        x = Math.abs(x);
        int rev = 0;
        while (x != 0){
            int tail = x % 10;
            int newRes = rev * 10 + tail;
            if ((newRes - tail) / 10 != rev){
                return 0; 
            }
            rev = newRes;
            x = x / 10;
        }
        return (sign * rev);
    }
}