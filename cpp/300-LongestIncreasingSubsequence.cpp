//Given [10, 9, 2, 5, 3, 7, 101, 18],
//The longest increasing subsequence is [2, 3, 7, 101]
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if (nums.empty())
            return 0;
        if (nums.size() == 1)
            return 1;
        vector<int> longest(nums.size(), 1);
        int res = 0;
        for (int i = 1; i < nums.size(); i++) {
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]) {
                    longest[i] = max(longest[j] + 1, longest[i]);
                }
            }
        }
        for (int i = 0; i < longest.size(); i++) {
            if (longest[i] > res)
                res = longest[i];
        }
        return res;
    }
};
