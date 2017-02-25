/*
Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

*/
class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> res;
        vector<int> curr;
        if (k == 0 || n == 0) {
            return res;
        }
        generate(res, curr, k, n, 1);
        return res;
    }

    void generate(vector<vector<int>>& res, vector<int> curr, int k, int target, int start) {
        if (target == 0 && curr.size() == k) {
            res.push_back(curr);
        }
        if (target > 0 && curr.size() < k) {
            for (int i = start; i <= 9; i++) {
                curr.push_back(i);
                generate(res, curr, k, target-i, i+1);
                curr.pop_back();
            }
        }
    }
};
