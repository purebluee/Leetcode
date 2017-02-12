//156323
//323651
class Solution {
public:
    int reverse(int x) {
        int res = 0;
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x *= sign;
        }
        while (x > 0) {
            int tmp = res * 10 + x % 10;
            if (tmp / 10 != res) {
                return 0;
            }
            res = tmp;
            x /= 10;
        }
        return res * sign;
    }
};
