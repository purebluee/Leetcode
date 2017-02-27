class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> curr;
        res.push_back({});
        sort(nums.begin(), nums.end());
        findSets(res, curr, nums, 0);
        return res;
    }
    void findSets(vector<vector<int>>& res, vector<int>& curr, vector<int>& nums, int start) {
        if (start >= nums.size()) {
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            curr.push_back(nums[i]);
            //attention here!
            res.push_back(curr);
            findSets(res, curr, nums, i+1);
            curr.pop_back();
        }
    }
};
