/*
Understand the problem:
The key of the problem is to understand the '*', which is able to match ANY sequence of characters. e.g. isMatch(abcd, *) -> true. 
Note that * does not require the same character in the sequence, as was required by the regular expression matching. 

We use DP to solve this problem. 
  -- Define dp[s.length() + 1][p.length() + 1], where dp[i[j] means the first i characters in string s matches the first characters of string p. 
  -- Initialization: dp[0][0] = true; 
                          dp[i][0] = false;
                          dp[0][j] = dp [0][j - 1] IFF p.charAt(j - 1) == '*'

-- Transit function: 
        -- If p.charAt(j - 1) != '*', then dp[i][j] = dp[i - 1][j - 1] IFF s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'
        -- If p.charAt(j - 1) == '*', then 
             -- dp[i][j] = dp[i - 1][j - 1] || // Match 1 character
                           = dp[i][j - 1] || // Match 0 character
                           = dp[i - 1][j] // Match any sequence of characters 

-- Return dp[s.length()][p.length()].
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        if (p == null || p.length() == 0) {
            return s == null || s.length() == 0;
        }
         
        int rows = s.length();
        int cols = p.length();
         
        boolean[][] dp = new boolean[rows + 1][cols + 1];
         
        dp[0][0] = true;
        for (int j = 1; j <= cols; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
         
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
         
        return dp[s.length()][p.length()];
    }
}