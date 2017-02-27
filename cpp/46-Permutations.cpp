/*
[ [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]]
*/
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> curr;
        if (nums.empty()) {
            return res;
        }
        vector<bool> visited(nums.size(), false);
        permute(res, curr, nums, visited);
        return res;
    }

    void permute(vector<vector<int>>& res, vector<int>& curr, vector<int>& nums, vector<bool>& visited) {
        if (curr.size() == nums.size()) {
            res.push_back(curr);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (visited[i])
                continue;
            curr.push_back(nums[i]);
            visited[i] = true;
            permute(res, curr, nums, visited);
            visited[i] = false;
            curr.pop_back();
        }
    }
};
