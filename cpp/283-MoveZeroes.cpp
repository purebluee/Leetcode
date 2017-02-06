class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int p1 = 0, p2 = 0, len = nums.size();
        while (p1 < len && p2 < len) {
            //p1: first 0
            while (p1 < len && nums[p1] != 0) {
                p1++;
            }
            p2 = p1;
            //p2: first num != 0
            while (p2 < len && nums[p2] == 0) {
                p2++;
            }
            if (p1 >= len || p2 >= len) {
                return;
            }
            int tmp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = tmp;
        }
    }
};
