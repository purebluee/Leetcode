//O(2n) space
public class Solution {
    public int numWays(int n, int k) {
        if (n <= 0 || k <= 0){
            return 0;
        }
        if (n == 1){
            return k;
        }
        //i-1 and i-2 with the same color
        int[] same = new int[n];
        //i-1 and i-2 with different color
        int[] diff = new int[n];
        same[0] = 0;
        diff[0] = k;
        for (int i = 1; i < n; i++){
            same[i] = diff[i - 1];
            diff[i] = (k - 1) * (same[i - 1] + diff[i - 1]);
        }
        return same[n - 1] + diff[n - 1];
    }
}
//O(1) space
public class Solution {
    public int numWays(int n, int k) {
        if (n <= 0 || k <= 0){
            return 0;
        }
        int preSame = 0;
        int preDiff = k;
        //int same = 0;
        //int diff = 0;
        for (int i = 1; i < n; i++){
            int same = preDiff;
            int diff = (k - 1) * (preSame + preDiff);
            preSame = same;
            preDiff = diff;
        }
        return preSame + preDiff;
    }
}