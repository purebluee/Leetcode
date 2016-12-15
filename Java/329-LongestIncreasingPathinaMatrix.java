/*
This is a very classic DFS + memorialization problem. If we only use the DFS solution, 
it will end with many repeated calculations. Therefore, for each element in the matrix[i][j], 
we use a DP array dp[i][j] to denote the length of the maximum increasing path from this point. 
So along with the DFS, for a point in the matrix, if we've already found the longest increasing path, 
we don't have to repeatedly compute it again; we just need to return the length, which is dp[i][j]. 

One trick here is dp[i][j] stores the length of the longest increasing path. That is because the DFS 
from a point matrix[i][j] can guarantee the longest path from this point. Since we store this value in the dp[i][j], 
that can guarantee that dp[i][j] is the longest path from the point matrix[i][j]. 
*/

public class Solution {
    private int[] dx = new int[]{0, 0, -1, 1};
    private int[] dy = new int[]{1, -1, 0, 0};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
         
        int m = matrix.length;
        int n = matrix[0].length;
         
        int max = 0;
        int[][] dp = new int[m][n];
         
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, helper(i, j, matrix, dp));
            }
        }
         
        return max;
    }
     
    private int helper(int row, int col, int[][] matrix, int[][] dp) {
 
        if (dp[row][col] > 0) {
            return dp[row][col];
        }
         
        int m = matrix.length;
        int n = matrix[0].length;
         
        int curMax = 0;
         
        for (int i = 0; i < 4; i++) {
            int x = dx[i] + row;
            int y = dy[i] + col;
             
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[row][col]) {
                curMax = Math.max(curMax, helper(x, y, matrix, dp));
            }
        }
         
        dp[row][col] = curMax + 1;
         
        return curMax + 1;
    }
}