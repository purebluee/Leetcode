class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        vector<int> curr;
        if (candidates.empty())
            return res;
        sort(candidates.begin(), candidates.end());
        combinations(candidates, res, curr, target, 0);
        return res;
    }
    void combinations(vector<int>& cand, vector<vector<int>>& res, vector<int> curr, int target, int start) {
        if (target == 0)
            res.push_back(curr);
        if (target > 0) {
            for (int i = start; i < cand.size(); i++) {
                if (i != start && cand[i] == cand[i-1])
                    continue;
                curr.push_back(cand[i]);
                combinations(cand, res, curr, target - cand[i], i + 1);
                curr.pop_back();
            }
        }
    }
};
