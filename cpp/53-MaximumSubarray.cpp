//maxSum: global optimal, dp[i] curr optimal
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int dp[nums.size() + 1] = {};
        int maxSum = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            dp[i] = max(nums[i], nums[i] + dp[i-1]);
            maxSum = max(maxSum, dp[i]);
        }
        return maxSum;
    }
};

//without dp array
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int local_max = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            local_max = max(nums[i], nums[i] + local_max);
            maxSum = max(maxSum, local_max);
        }
        return maxSum;
    }
};
