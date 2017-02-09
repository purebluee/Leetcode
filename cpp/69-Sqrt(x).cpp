class Solution {
public:
    int mySqrt(int x) {
        int start = 0, end = x;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return mid;
            }else if (mid * mid > x) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        //because int rounds down.
        return end;
    }
};
