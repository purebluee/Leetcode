//can be optimized:
//https://discuss.leetcode.com/topic/15269/10-lines-28ms-o-n-space-dp-solution-in-c-with-explanations
class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> sum(m, vector<int>(n, grid[0][0]));

        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            sum[0][j] = sum[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < grid.size(); i++) {
            for (int j = 1; j < grid[0].size(); j++) {
                sum[i][j] = min(sum[i-1][j] + grid[i][j], sum[i][j-1] + grid[i][j]);
            }
        }
        return sum[m-1][n-1];
    }
};
