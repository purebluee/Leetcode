class Solution {
public:
    bool canJump(vector<int>& nums) {
        if (nums.empty() || nums.size() == 1)
            return true;
        int maxStep = 0, len = nums.size();
        if (nums[0] == 0)
            return false;
        for (int i = 0; i < len; i++) {
            if (maxStep < i) {
                return false;
            } else if (maxStep >= len - 1) {
                return true;
            } else {
                maxStep = max(maxStep, i + nums[i]);
            }
        }
        return false;
    }
};
