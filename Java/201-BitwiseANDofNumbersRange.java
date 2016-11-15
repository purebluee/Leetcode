//It's a problem that can be reduced to find the same prefix of the numbers in this range.
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int diffBits = 0;
        while (m != n){
            m >>= 1;
            n >>= 1;
            diffBits++;
        }
        return n << diffBits;
    }
}