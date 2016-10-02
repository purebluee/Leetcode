public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1; //empty string: one way to decode
        dp[1] = s.charAt(0) == '0' ? 0 : 1; //string size of 1
        for (int i = 2; i <= len; i++){
            int first = Integer.valueOf(s.substring(i-1, i));//single digit
            int second = Integer.valueOf(s.substring(i-2, i));//two digits
            if (first >= 1 && first <= 9){
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }
}