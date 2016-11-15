/*
This problem can also be solved using a dynamic programming approach and some knowledge of combinatorics.
Let f(k) = count of numbers with unique digits with length equals k.
f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2) [The first factor is 9 because a number cannot start with 0].
*/
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0){
            return 1;
        }
        int res = 10, count = 9;
        for (int i = 2; i <= n; i++){
            count *= 9 - i + 2;
            res += count;
        }
        return res;
    }
}