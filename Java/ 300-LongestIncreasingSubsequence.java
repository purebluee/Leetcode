//https://discuss.leetcode.com/topic/30721/my-easy-to-understand-o-n-2-solution-using-dp-with-video-explanation
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        int max = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++){
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    if (dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }    
        for (int i = 0; i < dp.length; i++){
            max = Math.max(dp[i], max);
        }
        return max;
    }
}