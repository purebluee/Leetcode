class Solution {
public:
    int climbStairs(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        int count[n+1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            count[i] = count[i-1] + count[i-2];
        }
        return count[n];
    }
};

//without array
class Solution {
public:
    int climbStairs(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        //count1: 1 step before, count2: 2 step before
        int count1 = 1;
        int count2 = 1;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = count1 + count2;
            count2 = count1;
            count1 = curr;
        }
        return curr;
    }
};
