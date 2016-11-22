public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (j < nums.length){
            while (sum < s && j < nums.length){
                sum += nums[j];
                j++;
            }
            if (sum >= s){
                while (sum >= s && i < j){
                    sum -= nums[i];
                    i++;
                } 
                min = Math.min(min, j - i + 1);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}