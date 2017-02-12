//[1,2,3,4,5]

class Solution {
public:
    int thirdMax(vector<int>& nums) {
        long first = LONG_MIN, second = LONG_MIN, third = LONG_MIN;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            //Attention ! nums[i] < first
            } else if (nums[i] > second && nums[i] < first) {
                third = second;
                second = nums[i];
            } else if (nums[i] > third && nums[i] < second) {
                third = nums[i];
            }
        }
        //cout << first << " " << second << " " << third;
        //or:
        //return third == LONG_MIN ? first : third;
        return third == LONG_MIN ? second == LONG_MIN ? first : first : third;
    }
};
