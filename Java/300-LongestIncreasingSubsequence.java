//https://discuss.leetcode.com/topic/30721/my-easy-to-understand-o-n-2-solution-using-dp-with-video-explanation
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        // Base case
        if (nums.length == 1){
            return 1;
        }
        int max = 0;
        // This will be our array to track longest sequence length
        int[] dp = new int[nums.length];

        // Fill each position with value 1 in the array
        for (int i = 0; i < dp.length; i++){
            dp[i] = 1;
        }

        // Mark one pointer at i. For each i, start from j=0.
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                // It means next number contributes to increasing sequence.
                if (nums[i] > nums[j]){
                    // But increase the value only if it results in a larger value of the sequence than T[i]
                    // It is possible that T[i] already has larger value from some previous j'th iteration
                    if (dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }    
        // Find the maximum length from the array that we just generated 
        for (int i = 0; i < dp.length; i++){
            max = Math.max(dp[i], max);
        }
        return max;
    }
}