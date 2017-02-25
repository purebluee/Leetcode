//[-1, 0, 1, 2, -1, -4]
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        if (nums.size() < 3)
            return res;
        int first = 0, second = 1, third = nums.size() - 1;
        for (; first < nums.size() - 2; first++) {
            if (first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            second = first + 1;
            third = nums.size() - 1;
            while (second < third) {
                if (nums[first] + nums[second] + nums[third] == 0) {
                    res.push_back({nums[first], nums[second], nums[third]});
                    while (second < third && nums[second] == nums[second+1]) {
                        second++;
                    }
                    while (second < third && nums[third] == nums[third-1]) {
                        third--;
                    }
                    second++;
                    third--;
                } else if (nums[first] + nums[second] + nums[third] > 0) {
                    third--;
                } else {
                    second++;
                }
            }
        }
        return res;
    }
};
