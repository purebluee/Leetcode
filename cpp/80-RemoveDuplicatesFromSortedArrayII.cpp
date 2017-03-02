//[1,1,1,2,2,3]
//[1,1,2,2,3]
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty())
            return 0;
        int count = 0;
        int fast = 0, slow = 0;
        while (fast < nums.size()) {
            if (fast != 0 && nums[fast] != nums[fast-1]) {
                count = 1;
                nums[slow] = nums[fast];
                fast++;
                slow++;
            } else if (count < 2) {
                count++;
                nums[slow] = nums[fast];
                fast++;
                slow++;
            } else {
                fast++;
            }
        }
        return slow;
    }
};
