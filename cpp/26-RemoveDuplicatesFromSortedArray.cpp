//[1,1,2,2,3,3,4,4,5,6,7]
//Not swap!
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        int p1 = 1, p2 = 1, len = nums.size();
        while (p1 < len && p2 < len) {
            if (nums[p2] == nums[p2-1]) {
                p2++;
            } else {
                nums[p1] = nums[p2];
                p1++;
                p2++;
            }
        }
        return p1;
    }
};
