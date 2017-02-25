class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        vector<int> curr;
        if (candidates.empty() || target == 0) {
            return res;
        }
        combinations(res, curr, candidates, target, 0);
        return res;
    }

    void combinations(vector<vector<int>>& res, vector<int>& curr, vector<int>& candidates, int target, int start) {
        if (target == 0)
            res.push_back(curr);
        if (target > 0){
            for (int i = start; i < candidates.size(); i++) {
                curr.push_back(candidates[i]);
                combinations(res, curr, candidates, target - candidates[i], i);
                curr.pop_back();
            }
        }
    }
};
