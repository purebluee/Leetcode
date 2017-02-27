/*
small = so far best candidate of end element of a one-cell subsequence to form a triplet subsequence

mid = so far best candidate of end element of a two-cell subsequence to form a triplet subsequence

[2,1,0,6]
i:0 small:2147483647 mid:2147483647
if statement 1
i:1 small:2 mid:2147483647
if statement 1
i:2 small:1 mid:2147483647
if statement 1
i:3 small:0 mid:2147483647
if statement 2
*/
class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        if (nums.size() < 3)
            return false;
        int len = nums.size() - 1;
        int small = INT_MAX, mid = INT_MAX;
        for (int i = 0; i < nums.size(); i++) {
            //cout << "i:" << i << " small:" << small << " mid:" << mid << endl;
            if (nums[i] <= small) {
                //cout << "if statement 1" << endl;
                small = nums[i];
            } else if (nums[i] <= mid) {
                //cout << "if statement 2" << endl;
                mid = nums[i];
            } else if (nums[i] > mid && nums[i] > small) {
                //cout << "if statement 3" << endl;
                return true;
            }
        }
        return false;
    }
};
