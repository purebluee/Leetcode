/*
We use a 2D DP dp[i][j] denotes the minimum edit distance from substring[0, i] to substring[0, j]. So we wanna check the last element of the DP, which stands for the minimum distance from string 1 to string 2. 

The initial state, dp[0][j] = j, dp[i][0] = i. Means the minimum edit distance from empty string to string j and i is length of j and i, respectively. 

For dp[i][j], if word1.charAt(i) == word2.charAt(j), dp[i][j] = dp[i - 1][j - 1]. 
Else, there are three cases you must consider:

    Replace the word1.charAt(i) to word2.charAt(j), so dp[i][j] = dp[i - 1][j - 1] + 1. E.g. abd, abc, when i points to d and j points to c, its minimum edit distance equals to replacing d with c, which is the minimum edit distance from ab to ab plus 1. 
    Insert at word1.charAt(i) to word2.charAt(j), which equals to delete at word2.charAt(j). So dp[i][j] = dp[i][j - 1] + 1. E.g. ab to abc
    Delete at word1.charAt(i) to word2.charAt(j). So dp[i][j] = dp[i - 1][j]. E.g. abc to ab.
    We choose the minimum number from the above three cases. 

*/
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
         
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
         
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
         
        // update the first row
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
         
        // update the first column
        for (int j = 1; j <= m; j++) {
            dp[j][0] = j;
        }
         
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int replace = dp[i - 1][j - 1] + 1;
                    int insert = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                     
                    dp[i][j] = Math.min(replace, Math.min(insert, delete));
                }
            }
        }
         
        return dp[m][n];
    }
}