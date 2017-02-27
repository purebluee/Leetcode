//与I的区别在于有重复元素，所以在解集中要去重复。
//思路和combination II, subset II的去重复基本一致。通过排序
//每层递归跳过重复数字。注意这里的重复数字指的是一直到当前递归层，还未被使用的数字中的重复。
/*
https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
*/
class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> curr;
        vector<bool> visited(nums.size(), false);
        if (nums.empty())
            return res;
        sort(nums.begin(), nums.end());
        permute(res, nums, curr, visited);
        return res;
    }
    void permute(vector<vector<int>>& res, vector<int>& nums, vector<int>& curr, vector<bool>& visited) {
        if (curr.size() == nums.size()) {
            res.push_back(curr);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (visited[i]) {
                continue;
            }
            if (i != 0 && nums[i] == nums[i-1] && !visited[i-1]) {
                continue;
            }
            visited[i] = true;
            curr.push_back(nums[i]);
            permute(res, nums, curr, visited);
            visited[i] = false;
            curr.pop_back();
        }
    }
};
