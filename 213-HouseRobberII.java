public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)   return nums[0];
        return Math.max(helper(nums, 0, nums.length-2), helper(nums, 1, nums.length-1));
    }
    
    int helper(int[] nums, int start, int end){
        int include = 0, exclude = 0;
        for (int p = start; p <= end; p++){
            int i = include, e = exclude;
            include = e + nums[p];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }
}